package com.postsql.postsql.service.implementation;

import com.postsql.postsql.entity.Post;
import com.postsql.postsql.payload.PostDto;
import com.postsql.postsql.repository.PostRepository;
import com.postsql.postsql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = mapToEntity(postDto);
        Post savePost = postRepository.save(post);
        PostDto postResponse = mapToDTO(savePost);
        return postResponse;
    }


    @Override
    public List<PostDto> getPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = mapToDTO(post);
        }
        return postDtos;
    }

    @Override
    public PostDto getPost(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
        PostDto postDto = mapToDTO(post);
        return postDto;

    }
    @Override
    public PostDto updatePost(PostDto postDto,long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savePost = postRepository.save(post);
        return mapToDTO(savePost);
    }
    @Override
    public void deletePost(long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


}

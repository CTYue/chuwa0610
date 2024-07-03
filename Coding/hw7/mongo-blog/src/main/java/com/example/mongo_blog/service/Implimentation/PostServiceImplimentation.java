package com.chuwa.redbook.service.Implimentation;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplimentation implements PostService {


    private PostRepository postRepository;


    public PostServiceImplimentation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(@RequestBody PostDto postDto) {
        // step1 create object "Post"
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        // step connect ro DB and save object "Post"
        Post savedPost = postRepository.save(post);
        PostDto responce = posttoPostDto(savedPost);

        return responce;
    }

    private static PostDto posttoPostDto(Post savedPost) {
        PostDto responce = new PostDto();
        responce.setTitle(savedPost.getTitle());
        responce.setContent(savedPost.getContent());
        responce.setDescription(savedPost.getDescription());
        responce.setId(savedPost.getId());
        return responce;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> responces = posts.stream().map(post -> posttoPostDto(post)).collect(Collectors.toList());
        return responces;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));

        return posttoPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, Long id) {
        // step1 : get old post
        Post oldPost = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
        // step2 : update  old post with new post
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        postRepository.save(oldPost);
        // step3: return
        return posttoPostDto(oldPost);

    }
}

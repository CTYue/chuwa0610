package com.chuwa.redbook.service.Impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public  PostDto createPost(PostDto postDto) {
        // convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
        return transferPostToPostDto(savedPost);

    }




    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(Long postId) {
        //Post post = postRepository.findById(postId).orElse(null);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return transferPostToPostDto(post);
    }

    public PostDto updatePostById(PostDto postDto, Long postId) {
        Post oldPost = postRepository.findById(postId).orElse(null);

        oldPost.setTitle(postDto.getTitle());
        oldPost.setContent(postDto.getContent());
        oldPost.setDescription(postDto.getDescription());
        postRepository.save(oldPost);

        return transferPostToPostDto(oldPost);
    }

    @Override
    public boolean deletePostById(Long id) {
        try {
            postRepository.deleteById(id);
            return true; // 假设删除成功
        } catch (Exception e) {
            // 处理删除失败的情况
            return false;
        }
    }

    @Override
    public PostDto transferPostToPostDto(Post post) {

// convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());
        return postResponse;
    }

}

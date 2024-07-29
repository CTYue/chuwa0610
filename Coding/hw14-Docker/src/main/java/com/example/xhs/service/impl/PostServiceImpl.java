package com.example.xhs.service.impl;

import com.example.xhs.dao.PostRepository;
import com.example.xhs.entity.Post;
import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.PostDto;
import com.example.xhs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        //step 1: create object "Post"
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        //step 2: connect to DB and save object "Post"
        Post savedPost = postRepository.save(post);
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());
        return response;
    }


    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDto = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return transferPostToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto newPost, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());
        post.setDescription(newPost.getDescription());
        postRepository.save(post);

        return transferPostToPostDto(post);
    }

    @Override
    public PostDto deleteById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.deleteById(postId);
        return transferPostToPostDto(post);
    }

    private PostDto transferPostToPostDto(Post post){
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());
        return response;
    }
}

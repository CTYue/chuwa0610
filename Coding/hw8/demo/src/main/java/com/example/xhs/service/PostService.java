package com.example.xhs.service;

import com.example.xhs.entity.Post;
import com.example.xhs.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto newPost, long postId);

    PostDto deleteById(Long postId);
}


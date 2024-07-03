package com.example.mongo_blog.service;


import com.example.mongo_blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
/*
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, Long id);*/
}

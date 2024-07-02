package com.example.chuwa.mongo_blog.service;

import com.example.chuwa.mongo_blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}

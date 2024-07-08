package com.example.xhs.service;

import com.example.xhs.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();
    List<PostDto> getAllPostSort(int page, int size, String sort, String order);
    List<PostDto> getPostLimit();

    PostDto getPostById(long postId);

    PostDto updatePost(PostDto postDto, long postId);

    void deletePostById(long postId);
    PostDto getPostByTitle(String title);
}

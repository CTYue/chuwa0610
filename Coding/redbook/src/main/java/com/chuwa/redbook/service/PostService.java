package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePostById(long id);
}
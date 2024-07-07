package com.postsql.postsql.service;

import com.postsql.postsql.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getPosts();

    PostDto getPost(long id);
    PostDto updatePost(PostDto postDto,long id);
    void deletePost(long id);

}

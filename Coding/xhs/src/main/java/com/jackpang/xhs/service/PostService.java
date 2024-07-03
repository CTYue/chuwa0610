package com.jackpang.xhs.service;

import com.jackpang.xhs.entity.Post;
import com.jackpang.xhs.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto, Long id);

    PostDto deleteById(Long id);
}

package com.jackpang.xhs.service;

import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto, Long id);

    PostDto deleteById(Long id);
}

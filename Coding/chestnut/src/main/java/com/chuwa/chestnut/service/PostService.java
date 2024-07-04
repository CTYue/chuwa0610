package com.chuwa.chestnut.service;

import com.chuwa.chestnut.entity.Post;
import com.chuwa.chestnut.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto postDto, Long id);

    boolean deletePost(PostDto postDto, Long id);

}

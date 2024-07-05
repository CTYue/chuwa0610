package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {


    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();
    PostDto getPostById(Long postId);
    PostDto updatePostById(PostDto postDto, Long id);
    boolean deletePostById(Long id);

    PostDto transferPostToPostDto(Post post);
}

package com.chuwa.redbook.Service;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {


    PostDto createPost(PostDto postDto);

    // fetch all data from the database
    List<PostDto> getAllPost();

    //fetch a single data from id
    PostDto getPostById(Long postId);

    //update data
    PostDto updatePost(PostDto postDto, Long postId);

    //Delete data
    PostDto deletePost(Long postId);

    // integrate the getAllPost method with pagination and sorting into your PostServiceImpl class.
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}

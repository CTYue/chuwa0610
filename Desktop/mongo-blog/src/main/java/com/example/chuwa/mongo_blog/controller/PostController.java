package com.example.chuwa.mongo_blog.controller;

import com.example.chuwa.mongo_blog.payload.PostDto;
import com.example.chuwa.mongo_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    public ResponseEntity<PostDto> createPost(PostDto postDto) {
        PostDto response = postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

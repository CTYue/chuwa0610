package com.jackpang.xhs.controller;

import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: PostController
 * date: 6/28/24 10:21 PM
 * author: jinhao_pang
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = postService.createPost(postDto);
//        return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.updatePost(postDto,id));
    }
}

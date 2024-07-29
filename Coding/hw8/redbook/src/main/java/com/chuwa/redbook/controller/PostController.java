package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = postService.createPost(postDto);
        return ResponseEntity.ok(response);
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
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
        PostDto updateDto = postService.updatePostById(postDto, id);
        return ResponseEntity.ok(updateDto);
    }

    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok("delete ok");
    }

}

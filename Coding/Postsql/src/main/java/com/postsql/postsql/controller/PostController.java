package com.postsql.postsql.controller;


import com.postsql.postsql.entity.Post;
import com.postsql.postsql.payload.PostDto;
import com.postsql.postsql.service.PostService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postresponse = postService.createPost(postDto);
        return new ResponseEntity<>(postresponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> getPosts() {
        List<PostDto> postresponse = postService.getPosts();
        return ResponseEntity.ok(postresponse);
    }


    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id){
        PostDto postresponse = postService.getPost(id);
        return ResponseEntity.ok(postresponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name="id") long id){
        PostDto postresponse = postService.updatePost(postDto,id);
        return ResponseEntity.ok(postresponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}



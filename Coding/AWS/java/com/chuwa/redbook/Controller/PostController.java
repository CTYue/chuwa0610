package com.chuwa.redbook.Controller;

import com.chuwa.redbook.Entity.Post;
import com.chuwa.redbook.Exception.ResourceNotFoundException;
import com.chuwa.redbook.Service.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/get")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
        return ResponseEntity.ok(post);
    }
}
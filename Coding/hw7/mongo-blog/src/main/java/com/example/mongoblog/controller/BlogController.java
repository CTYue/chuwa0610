package com.example.mongoblog.controller;

import com.example.mongoblog.dao.BlogRepository;
import com.example.mongoblog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/blog"))
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping
    public ResponseEntity<Blog> createPost(@RequestBody Blog blog) {
        Blog rtnBLog = blogRepository.save(blog);
        return new ResponseEntity<>(rtnBLog, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Blog>> getAllPosts() {
        List<Blog> rtnBLog = blogRepository.findAll();
        return new ResponseEntity<>(rtnBLog, HttpStatus.CREATED);
    }
}

package com.example.mongoblog.controller;

import com.example.mongoblog.dao.BlogRepository;
import com.example.mongoblog.entity.Blog;
import com.example.mongoblog.payload.BlogDto;
import com.example.mongoblog.service.BlogService;
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
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        BlogDto rtnBLog = blogService.createBlog(blogDto);
        return new ResponseEntity<>(rtnBLog, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        List<BlogDto> rtnBLog = blogService.getAllBlog();
        return new ResponseEntity<>(rtnBLog, HttpStatus.CREATED);
    }
}

package com.example.mongo_blog.controller;

import com.example.mongo_blog.model.BlogPost;
import com.example.mongo_blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
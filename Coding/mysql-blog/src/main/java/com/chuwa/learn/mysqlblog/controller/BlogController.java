package com.chuwa.learn.mysqlblog.controller;

import com.chuwa.learn.mysqlblog.dto.BlogDTO;
import com.chuwa.learn.mysqlblog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/posts")
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO){
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") long id){
        blogService.deleteBlogById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }


}

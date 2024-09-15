package com.chuwa.learn.mysqlblog.controller;

import com.chuwa.learn.mysqlblog.payload.BlogDTO;
import com.chuwa.learn.mysqlblog.payload.BlogResponse;
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

    @GetMapping()
    public BlogResponse getAllBlogs(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "create_date_time", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir
    ) {
        return blogService.getAllBlog(pageNo, pageSize, sortBy, sortDir);
    }

    @PostMapping()
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO){
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") long id){
        blogService.deleteBlogById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlogById(@RequestBody BlogDTO blogDTO, @PathVariable(name = "id") long id){
        BlogDTO blogResponse = blogService.updateBlog(blogDTO, id);
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }
}

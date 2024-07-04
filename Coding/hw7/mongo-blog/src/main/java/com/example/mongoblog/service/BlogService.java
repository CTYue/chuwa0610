package com.example.mongoblog.service;



import com.example.mongoblog.payload.BlogDto;

import java.util.List;

public interface BlogService {
    BlogDto createBlog(BlogDto blog);
    List<BlogDto> getAllBlog();
}

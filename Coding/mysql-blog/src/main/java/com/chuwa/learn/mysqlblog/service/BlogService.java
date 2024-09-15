package com.chuwa.learn.mysqlblog.service;

import com.chuwa.learn.mysqlblog.payload.BlogDTO;
import com.chuwa.learn.mysqlblog.payload.BlogResponse;

import java.util.List;


public interface BlogService {
    BlogDTO createBlog(BlogDTO blogDto);
    void deleteBlogById(long id);
    BlogResponse getAllBlog(int pageNo, int pageSize, String sortBy, String sortDir);
    List<BlogDTO> getAllBlog();
    BlogDTO updateBlog(BlogDTO blogDTO, long id);

}

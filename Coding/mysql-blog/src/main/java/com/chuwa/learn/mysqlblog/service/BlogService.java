package com.chuwa.learn.mysqlblog.service;

import com.chuwa.learn.mysqlblog.dto.BlogDTO;


public interface BlogService {
    BlogDTO createBlog(BlogDTO blogDto);
    void deleteBlogById(long id);

}

package com.chuwa.learn.mongoblog.service;

import com.chuwa.learn.mongoblog.dto.BlogDTO;

public interface BlogService {
    BlogDTO createBlog(BlogDTO blogDTO);
}

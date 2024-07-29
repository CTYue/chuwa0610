package com.chuwa.learn.graphqlblog.service;

import com.chuwa.learn.graphqlblog.dto.BlogDto;

import java.util.List;

public interface BlogService {
    List<BlogDto> getBlog();
}

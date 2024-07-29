package com.chuwa.learn.graphqlblog.service;

import com.chuwa.learn.graphqlblog.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getPost();
}

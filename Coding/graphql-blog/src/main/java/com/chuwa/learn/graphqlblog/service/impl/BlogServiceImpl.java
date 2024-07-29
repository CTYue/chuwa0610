package com.chuwa.learn.graphqlblog.service.impl;

import com.chuwa.learn.graphqlblog.dao.BlogRepository;
import com.chuwa.learn.graphqlblog.dto.BlogDto;
import com.chuwa.learn.graphqlblog.entity.Blog;
import com.chuwa.learn.graphqlblog.service.BlogService;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogDto> getBlog(){
        List<Blog> blogs = blogRepository.findAll();
        List<BlogDto> blogDtos = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogDto dto = new BlogDto();
            dto.setId(blog.getId().toString()); // 确保ID是字符串类型
            dto.setTitle(blog.getTitle());
            dto.setContent(blog.getContent());
            dto.setCreateTime(blog.getCreateTime());
            dto.setUpdateTime(blog.getUpdateTime());
            blogDtos.add(dto);
        }
        return blogDtos;
    }
}

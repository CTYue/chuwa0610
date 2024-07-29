package com.chuwa.learn.graphqlblog.controller;

import com.chuwa.learn.graphqlblog.dto.BlogDto;
import com.chuwa.learn.graphqlblog.service.BlogService;
import graphql.kickstart.annotations.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogQueryResolver implements GraphQLQueryResolver {
    private final BlogService blogService;

    public BlogQueryResolver(BlogService blogService){
        this.blogService = blogService;
    }

    public List<BlogDto> getBlogs() {
        return blogService.getBlog();
    }
}

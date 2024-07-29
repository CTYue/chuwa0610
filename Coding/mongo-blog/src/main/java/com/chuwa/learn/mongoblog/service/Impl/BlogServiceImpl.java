package com.chuwa.learn.mongoblog.service.Impl;

import com.chuwa.learn.mongoblog.dao.BlogRepository;
import com.chuwa.learn.mongoblog.dto.BlogDTO;
import com.chuwa.learn.mongoblog.entity.Blog;
import com.chuwa.learn.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @Override
    public BlogDTO createBlog(BlogDTO blogDTO){
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setCreateTime(blogDTO.getCreateTime() != null ? blogDTO.getCreateTime() : LocalDateTime.now());
        blog.setUpdateTime(blogDTO.getUpdateTime() != null ? blogDTO.getUpdateTime() : LocalDateTime.now());

        Blog savedBlog = blogRepository.save(blog);
        BlogDTO response = new BlogDTO();
        response.setId(savedBlog.getId());
        response.setTitle(savedBlog.getTitle());
        response.setContent(savedBlog.getContent());
        response.setCreateTime(savedBlog.getCreateTime());
        response.setUpdateTime(savedBlog.getUpdateTime());

        return response;
    }
}

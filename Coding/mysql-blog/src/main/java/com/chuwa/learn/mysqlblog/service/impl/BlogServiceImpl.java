package com.chuwa.learn.mysqlblog.service.impl;

import com.chuwa.learn.mysqlblog.dao.BlogRepository;
import com.chuwa.learn.mysqlblog.dto.BlogDTO;
import com.chuwa.learn.mysqlblog.entity.Blog;
import com.chuwa.learn.mysqlblog.exception.ResourceNotFoundException;
import com.chuwa.learn.mysqlblog.service.BlogService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
        blog.setDescription(blogDTO.getDescription());
        blog.setCreateDateTime(blogDTO.getCreateTime() != null ? blogDTO.getCreateTime() : LocalDateTime.now());
        blog.setUpdateDateTime(blogDTO.getUpdateTime() != null ? blogDTO.getUpdateTime() : LocalDateTime.now());

        Blog savedBlog = blogRepository.save(blog);

        BlogDTO response = new BlogDTO();
        response.setId(savedBlog.getId());
        response.setTitle(savedBlog.getTitle());
        response.setContent(savedBlog.getContent());
        response.setDescription(savedBlog.getDescription());
        response.setCreateTime(savedBlog.getCreateDateTime());
        response.setUpdateTime(savedBlog.getUpdateDateTime());
        return response;
    }

    @Override
    public void deleteBlogById(long id) {
        // 使用 findById 查找博客
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));

        // 删除找到的博客
        blogRepository.delete(blog);
    }
}

package com.example.mongoblog.service.Impl;

import com.example.mongoblog.dao.BlogRepository;
import com.example.mongoblog.entity.Blog;
import com.example.mongoblog.payload.BlogDto;
import com.example.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private BlogDto transferBlog(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setContent(blog.getContent());
        blogDto.setAuthor(blog.getAuthor());
        return blogDto;
    }
    private Blog transferBlogDto(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setAuthor(blogDto.getAuthor());
        return blog;
    }
    @Override
    public BlogDto createBlog(BlogDto blog) {
        Blog blogToSave = transferBlogDto(blog);
        Blog blog2 = blogRepository.save(blogToSave);

        Blog saveBlog =  blogRepository.save(blog2);
        return transferBlog(blogToSave);
    }

    @Override
    public List<BlogDto> getAllBlog() {
        List<Blog> blogs = blogRepository.findAll();

        return blogs.stream().map(this::transferBlog).toList();
    }
}

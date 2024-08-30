package com.chuwa.learn.mysqlblog.service.impl;

import com.chuwa.learn.mysqlblog.dao.BlogRepository;
import com.chuwa.learn.mysqlblog.payload.BlogDTO;
import com.chuwa.learn.mysqlblog.payload.BlogResponse;
import com.chuwa.learn.mysqlblog.entity.Blog;
import com.chuwa.learn.mysqlblog.exception.ResourceNotFoundException;
import com.chuwa.learn.mysqlblog.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO){
        Blog blog = mapToEntity(blogDTO);
//        blog.setTitle(blogDTO.getTitle());
//        blog.setContent(blogDTO.getContent());
//        blog.setDescription(blogDTO.getDescription());
//        blog.setCreateDateTime(blogDTO.getCreateTime() != null ? blogDTO.getCreateTime() : LocalDateTime.now());
//        blog.setUpdateDateTime(blogDTO.getUpdateTime() != null ? blogDTO.getUpdateTime() : LocalDateTime.now());

        Blog savedBlog = blogRepository.save(blog);

        BlogDTO response = mapToDTO(savedBlog);
//        response.setId(savedBlog.getId());
//        response.setTitle(savedBlog.getTitle());
//        response.setContent(savedBlog.getContent());
//        response.setDescription(savedBlog.getDescription());
//        response.setCreateTime(savedBlog.getCreateDateTime());
//        response.setUpdateTime(savedBlog.getUpdateDateTime());
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

    @Override
    public List<BlogDTO> getAllBlog(){
        List<Blog> blogs = blogRepository.findAll();
        List<BlogDTO> blogDTOS = blogs.stream().map(blog -> mapToDTO(blog)).collect(Collectors.toList());
        return blogDTOS;
    }

    @Override
    public BlogResponse getAllBlog(int pageNo, int pageSize, String sortBy, String sortDir){
        System.out.println("get All blog:: ");
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // 分页
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        System.out.println(pageRequest);
        Page<Blog> pageBlogs = blogRepository.findAll(pageRequest);

        List<Blog> Blogs = pageBlogs.getContent();

        // map to list
        List<BlogDTO> blogDTOS = Blogs.stream()
                .map(blog -> mapToDTO(blog))
                .collect(Collectors.toList());
        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setContent(blogDTOS);
        blogResponse.setPageSize(pageBlogs.getSize());
        blogResponse.setTotalElements(pageBlogs.getTotalElements());
        blogResponse.setTotalPages(pageBlogs.getTotalPages());
        blogResponse.setLast(pageBlogs.isLast());
        return blogResponse;
    }

    @Override
    public BlogDTO updateBlog (BlogDTO blogDTO, long id){
        System.out.println("blogDto"+ blogDTO);
        Blog blog = blogRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        System.out.println("Blog: " + blog);
        blog = mapToEntity(blogDTO);
        Blog updateBlog = blogRepository.save(blog);
        return mapToDTO(updateBlog);
    }

    private BlogDTO mapToDTO(Blog blog){
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setDescription(blog.getDescription());
        blogDTO.setContent(blog.getContent());
        return blogDTO;
    }

    private Blog mapToEntity(BlogDTO blogDTO){
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setContent(blogDTO.getContent());
        return blog;
    }

}

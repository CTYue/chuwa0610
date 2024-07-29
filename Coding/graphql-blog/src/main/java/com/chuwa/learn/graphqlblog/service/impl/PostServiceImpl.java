package com.chuwa.learn.graphqlblog.service.impl;

import com.chuwa.learn.graphqlblog.dao.PostRepository;
import com.chuwa.learn.graphqlblog.dto.PostDto;
import com.chuwa.learn.graphqlblog.entity.Post;
import com.chuwa.learn.graphqlblog.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public List<PostDto> getPost(){
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for(Post post: posts){
            PostDto dto = new PostDto();
            dto.setId(post.getId()); // 确保ID是字符串类型
            dto.setTitle(post.getTitle());
            dto.setContent(post.getContent());
            dto.setCreateTime(post.getCreateDateTime());
            dto.setUpdateTime(post.getUpdateDateTime());
            postDtos.add(dto);
        }
        return postDtos;
    }
}

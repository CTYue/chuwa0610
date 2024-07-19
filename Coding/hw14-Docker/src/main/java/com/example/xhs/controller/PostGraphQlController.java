package com.example.xhs.controller;

import com.example.xhs.entity.Post;
import com.example.xhs.payload.PostDto;
import com.example.xhs.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostGraphQlController {

    private PostService postService;

    public PostGraphQlController(PostService postService){
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getById(@Argument long id){
        return postService.getPostById(id);
    }

    @QueryMapping
    public List<PostDto> getAllPost(){
        return postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setDescription(description);

        return postService.createPost(postDto);
    }

}

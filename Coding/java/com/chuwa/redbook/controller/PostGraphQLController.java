package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.Service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

@Controller
public class PostGraphQLController {
    private final PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getById(@Argument long id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public List<PostDto> getAllPost() {
        return postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content) {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setContent(content);
        return postService.createPost(postDto);
    }
}

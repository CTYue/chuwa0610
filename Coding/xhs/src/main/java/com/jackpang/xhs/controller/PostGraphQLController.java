package com.jackpang.xhs.controller;

import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * description: PostGraphQLController
 * date: 7/1/24 10:09 PM
 * author: jinhao_pang
 * version: 1.0
 */
@Controller
@RequiredArgsConstructor
public class PostGraphQLController {
    private final PostService postService;

    @QueryMapping
    public PostDto getById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public List<PostDto> getAllPost() {
        return postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String content, @Argument String description) {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setDescription(description);
        return postService.createPost(postDto);
    }

    @MutationMapping
    public PostDto deleteById(@Argument Long id) {
        return postService.deleteById(id);
    }
}

package com.chuwa.chestnut.controller;

import com.chuwa.chestnut.dao.PostRepository;
import com.chuwa.chestnut.payload.PostDto;
import com.chuwa.chestnut.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostGraphqlController {
    private PostService postService;

    public PostGraphqlController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getById(@Argument long id){
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description,@Argument String content) {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setDescription(description);
        return postService.createPost(postDto);
    }

    @QueryMapping
    public List<PostDto> getAllPost(){
        return postService.getAllPosts();
    }
}

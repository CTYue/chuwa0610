package com.example.xhs.controller;

import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.PostDto;
import com.example.xhs.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

@Controller
public class PostGraphQLController {
    private PostService postService;

    //constructor injection
    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getById(@Argument long id) {

        try {
            PostDto postDto  = postService.getPostById(id);
            System.out.println("find the id :" + id);
            return postDto;
        } catch (ResourceNotFoundException e) {
            System.out.println("didnt the id :" + id);
            return null;
        } catch (Exception e) {
            System.out.println("other issue");
            return null;
        }

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
    @MutationMapping
    public String deletePost(@Argument Long id) {
        try {
            postService.deletePostById(id);
            return "delete successfully";
        } catch (ResourceNotFoundException e) {
            return "not found";
        } catch (Exception e) {
            return "other issue";
        }

    }
}

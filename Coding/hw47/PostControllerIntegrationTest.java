package com.example.xhs.controller;

import com.example.xhs.dao.CommentRepository;
import com.example.xhs.dao.PostRepository;
import com.example.xhs.payload.PostDto;
import com.example.xhs.service.Impl.CommentServiceImpl;
import com.example.xhs.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private PostServiceImpl postService;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostController postController;



    private PostDto postDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample PostDto
        postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("Sample Title");
        postDto.setContent("Sample Content");
        postDto.setDescription("Sample Description");
    }

    @Test
    void testCreatePost() throws Exception {
        when(postService.createPost(any(PostDto.class))).thenReturn(postDto);


        mockMvc.perform(post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Sample Title"));
    }

    @Test
    void testGetAllPosts() throws Exception {

        List<PostDto> allPosts = Collections.singletonList(postDto);

        when(postService.getAllPost()).thenReturn(allPosts);
        postService.getAllPost().forEach(System.out::println);
        mockMvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Sample Title"));
    }


    @Test
    void getPostById() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setTitle("Test Post");
        postDto.setContent("Test Content");

        when(postService.getPostById(1L)).thenReturn(postDto);

        mockMvc.perform(get("/api/v1/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Post"));
    }



    @Test
    void deleteByID() throws Exception {
        mockMvc.perform(delete("/api/v1/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("delete successfully"));
    }

}
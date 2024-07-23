package com.chuwa.redbook.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PostController.class)
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Autowired
    private ObjectMapper objectMapper;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post(1L, "Title", "Content");
    }

    @Test
    void testCreatePost() throws Exception {
        when(postService.createPost(any(Post.class))).thenReturn(post);

        mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.content", is("Content")));
    }

    @Test
    void testGetPostById() throws Exception {
        when(postService.getPostById(1L)).thenReturn(post);

        mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.content", is("Content")));
    }

    @Test
    void testUpdatePost() throws Exception {
        Post updatedPost = new Post(1L, "Updated Title", "Updated Content");
        when(postService.updatePost(eq(1L), any(Post.class))).thenReturn(updatedPost);

        mockMvc.perform(put("/posts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedPost)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Updated Title")))
                .andExpect(jsonPath("$.content", is("Updated Content")));
    }

    @Test
    void testDeletePost() throws Exception {
        mockMvc.perform(delete("/posts/1"))
                .andExpect(status().isNoContent());

        verify(postService).deletePost(1L);
    }

    @Test
    void testGetPostByIdNotFound() throws Exception {
        when(postService.getPostById(1L)).thenThrow(new PostNotFoundException("Post not found"));

        mockMvc.perform(get("/posts/1"))
                .andExpect(status().isNotFound());
    }
}

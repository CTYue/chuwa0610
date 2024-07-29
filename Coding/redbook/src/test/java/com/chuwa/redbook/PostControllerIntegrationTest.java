package com.chuwa.redbook;

import com.chuwa.redbook.controller.PostController;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import io.cucumber.java.zh_cn.那么;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private PostDto postDto;
    private PostDto updatedPostDto;

    @BeforeEach
    public void setup() {
        postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("Test Title");
        postDto.setContent("Test Body");

        updatedPostDto = new PostDto();
        updatedPostDto.setId(1L);
        updatedPostDto.setTitle("Updated Title");
        updatedPostDto.setContent("Updated Body");
    }

    @Test
    public void testCreatePost() throws Exception {
        when(postService.createPost(any(PostDto.class))).thenReturn(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Test Title\",\"body\":\"Test Body\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.body").value("Test Body"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetAllPosts() throws Exception {
        when(postService.getAllPosts()).thenReturn(List.of(postDto));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Test Title"))
                .andExpect(jsonPath("$[0].body").value("Test Body"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetPostById() throws Exception {
        when(postService.getPostById(1L)).thenReturn(postDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.body").value("Test Body"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUpdatePostById() throws Exception {
        when(postService.updatePost(any(PostDto.class), eq(1L))).thenReturn(updatedPostDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Updated Title\",\"body\":\"Updated Body\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Updated Title"))
                .andExpect(jsonPath("$.body").value("Updated Body"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testDeletePostById() throws Exception {
        doNothing().when(postService).deletePostById(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Post: 1 Deleted"))
                .andDo(MockMvcResultHandlers.print());
    }
}

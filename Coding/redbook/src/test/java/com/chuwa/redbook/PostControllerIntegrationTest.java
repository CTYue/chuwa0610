import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PostController.class)
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @BeforeEach
    void setUp() {
        // Initialize mock data and behavior
    }

    @Test
    void testGetPostByIdSuccess() throws Exception {
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        when(postService.getPostById(postId)).thenReturn(post);

        mockMvc.perform(get("/posts/{id}", postId))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(postId));
    }

    @Test
    void testGetPostByIdNotFound() throws Exception {
        Long postId = 1L;
        when(postService.getPostById(postId)).thenThrow(new PostNotFoundException("Post not found"));

        mockMvc.perform(get("/posts/{id}", postId))
               .andExpect(status().isNotFound());
    }

    @Test
    void testCreatePost() throws Exception {
        Post post = new Post();
        post.setTitle("New Post");
        when(postService.createPost(any(Post.class))).thenReturn(post);

        mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Post\"}"))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.title").value("New Post"));
    }

    // Add more tests to cover all endpoints and scenarios
}

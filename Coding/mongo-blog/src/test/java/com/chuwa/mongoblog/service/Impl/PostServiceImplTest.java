//package com.chuwa.mongoblog.service.Impl;
//
//import com.chuwa.mongoblog.dto.PostDto;
//import com.chuwa.mongoblog.entity.Post;
//import com.chuwa.mongoblog.repository.PostRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @Create 08/2024
// * @Author xiao
// * @Description
// */
//@SpringBootTest
//public class PostServiceImplTest {
//
//
//    @Autowired
//    private PostServiceImpl postService;
//
//    @MockBean
//    private PostRepository postRepository;
//
//
//    @Test
//    public void testGetPostById() {
//        Long postId = 1L;
//        Post post = new Post();
//        post.setId(postId);
//        post.setTitle("Title");
//        post.setContent("Content");
//
//        Mockito.when(postRepository.findById(postId)).thenReturn(Optional.of(post));
//
//        PostDto postDto = postService.getPostById(postId);
//
//        assertEquals(postId, postDto.getId());
//        assertEquals("Title", postDto.getTitle());
//        assertEquals("Content", postDto.getContent());
//    }
//}

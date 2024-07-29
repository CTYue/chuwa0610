package com.example.xhs.service.Impl;



import com.example.xhs.dao.CommentRepository;
import com.example.xhs.dao.PostRepository;
import com.example.xhs.entity.Comment;
import com.example.xhs.entity.Post;
import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.CommentDto;
import com.example.xhs.service.CommentService;
import com.example.xhs.service.Impl.CommentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static graphql.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateComment(){
        long postId = 1L;
        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setName("John Doe");
        commentDto.setEmail("john@example.com");
        commentDto.setBody("This is a comment.");

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setId(1L);
        comment.setName("John Doe");
        comment.setEmail("john@example.com");
        comment.setBody("This is a comment.");
        comment.setPost(post);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto createdComment = commentService.createComment(postId, commentDto);

        assertNotNull(createdComment);
        assertEquals(commentDto.getId(), createdComment.getId());
        assertEquals(commentDto.getName(), createdComment.getName());
        verify(commentRepository).save(any(Comment.class));

    }

    @Test
    void testGetCommentsByPostId() {
        long postId = 1L;
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setName("John Doe");
        comment.setEmail("john@example.com");
        comment.setBody("This is a comment.");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        when(commentRepository.findByPostId(postId)).thenReturn(comments);

        List<CommentDto> commentDtos = commentService.getCommentsByPostId(postId);

        assertNotNull(commentDtos);
        assertEquals(1, commentDtos.size());
        assertEquals(comment.getId(), commentDtos.get(0).getId());
    }



    @Test
    void testGetCommentById_CommentNotBelongToPost() {
        long postId = 1L;
        long commentId = 1L;

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setPost(new Post());

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenThrow(new ResourceNotFoundException("Comment", "id", commentId));


        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.getCommentById(postId, commentId);
        });



    }

    @Test
    void testUpdateComment() {
        long postId = 1L;
        long commentId = 1L;
        CommentDto commentDtoRequest = new CommentDto();
        commentDtoRequest.setName("Updated Name");
        commentDtoRequest.setEmail("updated@example.com");
        commentDtoRequest.setBody("Updated comment body.");

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setPost(post);
        comment.setName("Old Name");
        comment.setEmail("old@example.com");
        comment.setBody("Old comment body.");

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDtoRequest);

        assertNotNull(updatedComment);
        assertEquals("Updated Name", updatedComment.getName());
        assertEquals("updated@example.com", updatedComment.getEmail());
        assertEquals("Updated comment body.", updatedComment.getBody());
    }

    @Test
    void testDeleteComment() {
        long postId = 1L;
        long commentId = 1L;

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setPost(post);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        commentService.deleteComment(postId, commentId);

        verify(commentRepository).delete(comment);
    }


}

package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;
import com.eurodyn.qlack2.fuse.blog.impl.CommentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddComment() {
        Comment comment = new Comment(1L, "Test comment");
        when(commentRepository.save(comment)).thenReturn(comment);

        Comment result = commentService.addComment(comment);
        assertEquals(comment, result);

        verify(commentRepository).save(comment);
    }

    @Test
    void testAddCommentNull() {
        assertThrows(IllegalArgumentException.class, () -> commentService.addComment(null));
    }

    @Test
    void testGetCommentById() {
        Comment comment = new Comment(1L, "Test comment");
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        Comment result = commentService.getCommentById(1L);
        assertEquals(comment, result);

        verify(commentRepository).findById(1L);
    }

    @Test
    void testGetCommentByIdNotFound() {
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CommentNotFoundException.class, () -> commentService.getCommentById(1L));
    }

    @Test
    void testDeleteComment() {
        when(commentRepository.existsById(1L)).thenReturn(true);

        commentService.deleteComment(1L);

        verify(commentRepository).deleteById(1L);
    }

    @Test
    void testDeleteCommentNotFound() {
        when(commentRepository.existsById(1L)).thenReturn(false);

        assertThrows(CommentNotFoundException.class, () -> commentService.deleteComment(1L));
    }
}

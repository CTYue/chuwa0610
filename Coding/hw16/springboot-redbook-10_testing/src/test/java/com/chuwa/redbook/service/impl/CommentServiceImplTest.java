package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.payload.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentServiceImpl commentService;
    private Comment comment;
    private CommentDto commentDto;
    @Mock(name="modelMapper")
    private ModelMapper mockedModelMapper;


    @BeforeEach
    void setUp() {
        this.comment = new Comment();
        this.commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setBody("asfadsfaef");
        commentDto.setName("asdasd");
        commentDto.setEmail("sss@aaa.com");
    }


    @Test
    public void testCreateCommentWithMockedModelMapper() {
        // Define modelMapper's two different behaviors (different converting sources and targets)
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(CommentDto.class), ArgumentMatchers.eq(Comment.class))).thenReturn(comment);
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(Comment.class), ArgumentMatchers.eq(CommentDto.class))).thenReturn(commentDto);
        Mockito.when(commentRepository.save(ArgumentMatchers.any())).thenReturn(comment);
        CommentDto commentResponse = commentService.createComment(commentDto.getId(), commentDto);

        // assertions
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());

    }


    @Test
    void getCommentsByPostId() {
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(Comment.class), ArgumentMatchers.eq(CommentDto.class))).thenReturn(commentDto);


        // execute
        List<CommentDto> commentResponse = commentService.getCommentsByPostId(1L);

        // assertions
        Assertions.assertNotNull(commentResponse);

    }

    @Test
    void getCommentById() {
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(Comment.class), ArgumentMatchers.eq(CommentDto.class))).thenReturn(commentDto);
        CommentDto commentResponse = commentService.getCommentById(1L, 1L);
        Assertions.assertNotNull(commentResponse);
    }

    @Test
    void updateComment() {
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(Comment.class), ArgumentMatchers.eq(CommentDto.class))).thenReturn(commentDto);

        CommentDto commentResponse = commentService.updateComment(1L, 1L, new CommentDto());
        // assertions
        Assertions.assertNotNull(commentResponse);
    }

    @Test
    void deleteComment() {
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(mockedModelMapper.map(ArgumentMatchers.any(Comment.class), ArgumentMatchers.eq(CommentDto.class))).thenReturn(commentDto);
        commentService.deleteComment(1L, 1L);
    }
}
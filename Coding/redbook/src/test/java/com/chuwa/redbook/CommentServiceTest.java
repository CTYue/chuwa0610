package com.chuwa.redbook;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.Implimentation.CommentServiceImplimentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private CommentServiceImplimentation commentService;

    private Post post;
    private Comment comment;
    private Post post2;
    private Comment comment2;
    private CommentDto commentDto;

    @BeforeEach
    public void setup() {
        post = new Post();
        post.setId(1L);

        post2 = new Post();
        post2.setId(2L);

        comment = new Comment();
        comment.setId(1L);
        comment.setName("Test Name");
        comment.setEmail("test@example.com");
        comment.setBody("Test Body");
        comment.setPost(post);

        comment2 = new Comment();
        comment2.setId(2L);
        comment2.setName("Test Name");
        comment2.setEmail("test@example.com");
        comment2.setBody("Test Body");
        comment2.setPost(post2);

        commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setName("Test Name");
        commentDto.setEmail("test@example.com");
        commentDto.setBody("Test Body");
    }
    @Test
    public void testCreateComment() {
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        CommentDto createdCommentDto = commentService.createComment(1L, commentDto);
        assertNotNull(createdCommentDto);
        assertEquals("Test Name", createdCommentDto.getName());

    }

    @Test
    public void testGetCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        when(commentRepository.findByPostId(1L)).thenReturn(comments);

        List<CommentDto> commentDtos = commentService.getCommentsByPostId(1L);
        assertNotNull(commentDtos);
        assertEquals(1, commentDtos.size());
        assertEquals("Test Name", commentDtos.get(0).getName());
    }

    @Test
    public void testGetCommentById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        CommentDto foundedComment = commentService.getCommentById(1L,1L);
        assertNotNull(foundedComment);
        assertEquals("Test Name", foundedComment.getName());
    }

    @Test
    public void testUpdateComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto updatedCommentDto = new CommentDto();
        updatedCommentDto.setName("Updated Name");
        updatedCommentDto.setEmail("updated@example.com");
        updatedCommentDto.setBody("Updated Body");

        CommentDto updatedComment = commentService.updateComment(1L, 1L, updatedCommentDto);

        assertNotNull(updatedComment);
        assertEquals("Updated Name", updatedComment.getName());
    }

    @Test
    public void testUpdateComment_ThrowBlogAPIException() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(2L)).thenReturn(Optional.of(comment2));

        CommentDto updatedCommentDto = new CommentDto();
        updatedCommentDto.setName("Updated Name");
        updatedCommentDto.setEmail("updated@example.com");
        updatedCommentDto.setBody("Updated Body");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> commentService.updateComment(1L, 2L, updatedCommentDto));
        //assertEquals("Comment does not belong to post", exception.getMessage());
    }

    @Test
    public void testDeleteComment() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        doNothing().when(commentRepository).delete(comment);

        commentService.deleteComment(1L, 1L);

        verify(commentRepository,times(1)).delete(comment);
    }

    @Test
    public void testDeleteComment_ThrowsBlogAPIException() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.findById(2L)).thenReturn(Optional.of(comment2));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            commentService.deleteComment(1L, 2L);
        });

        //assertEquals("Comment does not belong to post", exception.getMessage());
    }
    @Test
    public void testMapToDto() {
        CommentDto dto = commentService.mapToDto(comment);
        assertNotNull(dto);
        assertEquals(comment.getName(), dto.getName());
        assertEquals(comment.getBody(), dto.getBody());
        assertEquals(comment.getEmail(), dto.getEmail());
        assertEquals(comment.getId(), dto.getId());
    }

    @Test
    public void testMapToEntity() {
        Comment cm = commentService.mapToEntity(commentDto);
        assertNotNull(cm);
        assertEquals(commentDto.getName(), cm.getName());
        assertEquals(commentDto.getBody(), cm.getBody());
        assertEquals(commentDto.getEmail(), cm.getEmail());
        assertEquals(commentDto.getId(), cm.getId());
    }
}

package com.example.xhs.service.Impl;

import com.example.xhs.dao.CommentRepository;
import com.example.xhs.dao.PostRepository;
import com.example.xhs.entity.Comment;
import com.example.xhs.entity.Post;
import com.example.xhs.exception.BlogAPIException;
import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.CommentDto;
import com.example.xhs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return mapToDto(savedComment);

    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comemnts = commentRepository.findByPostId(postId);
        return comemnts.stream().map(this::mapToDto).toList();
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw  new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDtoRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        comment.setName(commentDtoRequest.getName());
        comment.setEmail(commentDtoRequest.getEmail());
        comment.setBody(commentDtoRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        commentRepository.delete(comment);
    }
}

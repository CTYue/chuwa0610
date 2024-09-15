package com.chuwa.learn.mysqlblog.service.impl;
import com.chuwa.learn.mysqlblog.entity.Blog;
import com.chuwa.learn.mysqlblog.dao.BlogRepository;
import com.chuwa.learn.mysqlblog.dao.CommentRepository;
import com.chuwa.learn.mysqlblog.entity.Comment;
import com.chuwa.learn.mysqlblog.exception.ResourceNotFoundException;
import com.chuwa.learn.mysqlblog.payload.CommentDTO;
import com.chuwa.learn.mysqlblog.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private BlogRepository blogRepository;

    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository){
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public CommentDTO createComment(long blogId, CommentDTO commentDTO){
        Comment comment = mapToEntity(commentDTO);
        Blog blog = blogRepository.findById(blogId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", blogId));
        comment.setBlog(blog);
        Comment savedComment = commentRepository.save(comment);
        return mapToDto(comment);
    }

    private Comment mapToEntity(CommentDTO commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
    private CommentDTO mapToDto(Comment comment){
        CommentDTO commentDto = new CommentDTO();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }
}

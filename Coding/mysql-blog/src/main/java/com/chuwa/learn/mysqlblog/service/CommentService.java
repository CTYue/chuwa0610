package com.chuwa.learn.mysqlblog.service;

import com.chuwa.learn.mysqlblog.payload.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO createComment(long blogId, CommentDTO commentDTO);
//    List<CommentDTO> getCommentsByBlogId(long blogId);
}

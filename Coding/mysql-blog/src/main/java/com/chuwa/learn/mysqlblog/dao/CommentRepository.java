package com.chuwa.learn.mysqlblog.dao;

import com.chuwa.learn.mysqlblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogId(long blogId);
}

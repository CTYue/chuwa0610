package com.chuwa.learn.graphqlblog.dao;

import com.chuwa.learn.graphqlblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

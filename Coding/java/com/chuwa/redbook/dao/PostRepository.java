package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //no code need here
    //why do not need code? because we already extend the JpaRepository because it already haves a series of method in so wo do not need more code writing
}
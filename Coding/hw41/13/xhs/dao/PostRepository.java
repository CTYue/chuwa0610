package com.example.xhs.dao;

import com.example.xhs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    List<Post> findTop2ByOrderByTitleDesc();


//    Post findByAge(int age);
    //no code needed here.ms
}

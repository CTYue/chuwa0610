package com.chuwa.redbook.Service;

import com.chuwa.redbook.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
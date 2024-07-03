package com.jackpang.xhs.dao;

import com.jackpang.xhs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description: PostRepository
 * date: 6/28/24 10:02 PM
 * author: jinhao_pang
 * version: 1.0
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

package com.jackpang.xhs.dao;

import com.jackpang.xhs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description: PostRepository
 * date: 6/28/24 10:02 PM
 * author: jinhao_pang
 * version: 1.0
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * 找到该时间段内所有段帖子
     * @param startTime
     * @param endTime
     * @return
     */
    @Query(value = "select * from posts where create_date_time between :startTime and :endTime", nativeQuery = true)
    List<Post> getAllPostIdsByCreateDateBetweenStartTimeAndEndTime(LocalDateTime startTime, LocalDateTime endTime);
}

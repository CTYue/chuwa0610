package com.chuwa.learn.mysqlblog.dao;

import com.chuwa.learn.mysqlblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}

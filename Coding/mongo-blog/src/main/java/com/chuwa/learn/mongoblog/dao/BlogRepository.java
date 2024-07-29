package com.chuwa.learn.mongoblog.dao;

import com.chuwa.learn.mongoblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, Long> {

}

package com.chuwa.learn.graphqlblog.dao;

import com.chuwa.learn.graphqlblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

}

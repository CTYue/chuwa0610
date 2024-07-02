package com.example.chuwa.mongo_blog.dao;

import com.example.chuwa.mongo_blog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, Long> {// entity class + primary key type
}

package com.example.mongo_blog.repository;

import com.example.mongo_blog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{id:'?0'}")
    Post findById(long id);


    public long count();

}

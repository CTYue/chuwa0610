package com.example.mongo_blog.repository;

import com.example.mongo_blog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
}
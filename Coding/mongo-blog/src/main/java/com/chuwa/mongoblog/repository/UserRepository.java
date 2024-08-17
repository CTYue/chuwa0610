package com.chuwa.mongoblog.repository;

import com.chuwa.mongoblog.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Create 07/2024
 * @Author xiao
 * @Description
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}


package com.postsql.backendapi.Repository;

import com.postsql.backendapi.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {


}

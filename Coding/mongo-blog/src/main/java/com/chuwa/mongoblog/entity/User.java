package com.chuwa.mongoblog.entity;

import jakarta.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Create 07/2024
 * @Author xiao
 * @Description  for mongoDB connection
 */

@Document(collection = "Users")
public class User {
	@Id
    private ObjectId id;
    private String name;
    private String address;



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

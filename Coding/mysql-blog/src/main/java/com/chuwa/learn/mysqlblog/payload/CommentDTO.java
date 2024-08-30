package com.chuwa.learn.mysqlblog.payload;

import lombok.Getter;
import lombok.Setter;

public class CommentDTO {
    // entity 中需要指明primary key
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String body;

    public CommentDTO(){}

    public CommentDTO(String name, String email, String body){
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public CommentDTO(long id, String name, String email, String body){
        this(name, email, body);
        this.id = id;
    }

    @Override
    public String toString(){
        return "CommentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

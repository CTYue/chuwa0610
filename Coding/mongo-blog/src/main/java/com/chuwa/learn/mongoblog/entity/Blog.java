package com.chuwa.learn.mongoblog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "blogs")
public class Blog {
    @Getter
    @Id
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private LocalDateTime createTime;

    @Getter
    @Setter
    private LocalDateTime updateTime;

}

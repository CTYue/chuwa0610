package com.chuwa.learn.graphqlblog.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @CreationTimestamp
    private LocalDateTime createTime;

    @Getter
    @Setter
    @UpdateTimestamp
    private LocalDateTime updateTime;

}

package com.example.mongoblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@NoArgsConstructor
@Document("blog")
public class Blog {
    @Id
    private String id;
    private String title;
    private String content;
    private String author;

    public Blog(String id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

package com.example.mongoblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private String id;
    private String title;
    private String content;
    private String author;
}

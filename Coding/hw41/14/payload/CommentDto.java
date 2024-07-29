package com.example.xhs.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}

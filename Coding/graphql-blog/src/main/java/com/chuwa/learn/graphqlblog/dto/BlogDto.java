package com.chuwa.learn.graphqlblog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BlogDto {
    @Getter
    @Setter
    private String id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String content;

    @Setter
    @Getter
    private LocalDateTime createTime;

    @Setter
    @Getter
    private LocalDateTime updateTime;
}

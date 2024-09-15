package com.chuwa.learn.mysqlblog.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BlogDTO {
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    private String title;

    @Getter
    @Setter
    private String content;

    @Setter
    @Getter
    private String description;

    @Getter
    @Setter
    private LocalDateTime createTime;

    @Setter
    @Getter
    private LocalDateTime updateTime;
}

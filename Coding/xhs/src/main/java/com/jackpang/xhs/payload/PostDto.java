package com.jackpang.xhs.payload;

import jakarta.annotation.Resource;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * description: PostDto
 * date: 6/28/24 10:04 PM
 * author: jinhao_pang
 * version: 1.0
 */
@Resource
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;
}

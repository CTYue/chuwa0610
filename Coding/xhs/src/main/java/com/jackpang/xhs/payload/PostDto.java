package com.jackpang.xhs.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
@Tag(name = "Post", description = "Post model information")
public class PostDto {
    @Schema(description = "Blog post id")
    private Long id;
    @Schema(description = "Blog post title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @Schema(description = "Blog post content")
    @NotEmpty
    private String content;
    @Size(min = 10, message = "Post description should have at least 10 characters")
    @Schema(description = "Blog post description")
    @NotEmpty
    private String description;
}

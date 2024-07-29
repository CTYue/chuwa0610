package com.jackpang.xhs.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jinhao
 * @date 7/8/24 11:10 PM
 */
@Data
@ToString
@NoArgsConstructor
@Tag(name = "Comment", description = "Comment model info")
public class CommentDto {

    @Schema(description = "Comment id")
    private long id;
    @Schema(description = "Comment name")
    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @Schema(description = "Comment email")
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    @Schema(description = "Comment body")
    @NotEmpty
    @Size(min = 5, message = "Comment body must be minimum 5 characters")
    private String body;

    public CommentDto(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public CommentDto(long id, String name, String email, String body) {
        this(name, email, body);
        this.id = id;
    }
}

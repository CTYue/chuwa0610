package com.example.xhs.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty
    @Size(min = 2, max = 20, message = "Comment name should at least 2 characters")
    private String name;

    @Email
    @Size(min = 5, max = 50, message = "Comment email should at least 2 characters")
    private String email;

    @NotEmpty
    private String body;
}

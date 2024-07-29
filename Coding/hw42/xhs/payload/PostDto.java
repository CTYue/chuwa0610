package com.example.xhs.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class PostDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Post title should at least 20 characters")
    private String title;

    @NotEmpty
    @Size(min = 2, message = "Post content should at least 20 characters")
    private String content;

    @NotEmpty
    @Size(min = 2, message = "Post description should at least 20 characters")
    private String description;

    private Set<CommentDto> comments;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

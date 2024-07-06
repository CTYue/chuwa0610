package com.chuwa.redbook.payload;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;

    public PostDto() {
    }

    public PostDto(String description, String content, String title, Long id) {
        this.description = description;
        this.content = content;
        this.title = title;
        this.id = id;
    }

    public Long getId() {
        return id;
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

package com.example.xhs.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAPIException extends RuntimeException {
    private HttpStatus HttpStatus;
    private String message;

    public BlogAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.message = message1;
        this.HttpStatus = status;
    }
}

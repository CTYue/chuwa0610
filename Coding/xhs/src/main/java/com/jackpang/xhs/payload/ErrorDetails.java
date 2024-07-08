package com.jackpang.xhs.payload;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * @author Jinhao
 * @date 7/8/24 11:10 PM
 */
@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}

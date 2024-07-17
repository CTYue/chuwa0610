package com.jackpang.xhs.payload.security;

import lombok.Data;

/**
 * @author b1go
 * @date 7/1/22 1:08 AM
 */
@Data
public class JWTAuthResponse {

    private String accessToken;
    private String tokenType;

    public JWTAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}

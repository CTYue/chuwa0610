package com.jackpang.xhs.payload.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author b1go
 * @date 6/26/22 5:25 PM
 */
@Data
@AllArgsConstructor
public class SignUpDto {
    private String name;
    @JsonProperty(value = "account")
    private String account;
    private String email;
    private String password;

}

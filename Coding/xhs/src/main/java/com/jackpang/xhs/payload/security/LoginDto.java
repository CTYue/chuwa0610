package com.jackpang.xhs.payload.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author b1go
 * @date 6/26/22 5:01 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @JsonProperty("accountOrEmail")
    private String accountOrEmail;
    private String password;

}

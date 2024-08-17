package com.chuwa.mongoblog.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Create 08/2024
 * @Author xiao
 * @Description
 */

@RestController
@RequestMapping("/user")
public class AuthController {

//    @PostMapping("/login")
//    public String login(@RequestBody SignInReq req) {
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//            new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
//        authenticationManager.authenticate(authenticationToken);
//
//        //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
//        String token = JWT.create()
//            .setPayload("username", req.getUsername())
//            .setKey(MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
//            .sign();
//    }

}

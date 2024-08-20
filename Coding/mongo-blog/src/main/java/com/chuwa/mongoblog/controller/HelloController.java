package com.chuwa.mongoblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/auth")
public class HelloController {
//     @RequestMapping(value = "/hello", method = RequestMethod.GET)
//     @ResponseBody
//     public String sayHello() {
//      return "Hello, World!";
//     }

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello, Security!";
    }
}

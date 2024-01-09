package com.steve.springboot.controller;

import com.steve.springboot.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: STEVE
 * @Description: hello
 * @since: 2024/1/4
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        return new User();
    }

}

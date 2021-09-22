package com.javaedge.spring.convert.controller;

import com.javaedge.spring.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JavaEdge
 * @date 2021/9/22
 */
@RestController
public class MyController {

    @GetMapping("hello")
    public User hello() {
        return new User(22, "JavaEdge");
    }
}

package com.javaedge.spring.value.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@RestController
@Slf4j
public class ValueController {

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @GetMapping(path = "user")
    public String getUser() {
        return user + ":" + password;
    }
}

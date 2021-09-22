package com.javaedge.spring.value.controller;

import com.javaedge.spring.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JavaEdge
 * @date 2021/9/12
 */
@RestController
@Slf4j
public class UserController {

    private List<User> users;

    public UserController(List<User> users) {
        this.users = users;
    }

    @GetMapping(path = "users")
    public String listUsers() {
        return users.toString();
    }
}

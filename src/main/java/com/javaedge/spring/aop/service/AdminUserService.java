package com.javaedge.spring.aop.service;

import com.javaedge.spring.aop.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@Service
public class AdminUserService {

    /**
     * 管理员用户
     */
    public final User admin = new User("110");

    public void login() {
        System.out.println("admin login...");
    }

    public User getUser() {
        return admin;
    }
}

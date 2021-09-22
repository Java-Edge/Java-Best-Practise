package com.javaedge.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}


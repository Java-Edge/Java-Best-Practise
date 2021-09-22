package com.javaedge.spring.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
//@ComponentScan("com.javaedge.spring.autowired.controller")
//@ComponentScans(value = {@ComponentScan(value = "com.javaedge.spring.autowired.controller")})
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}

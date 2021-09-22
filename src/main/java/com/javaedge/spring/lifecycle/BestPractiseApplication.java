package com.javaedge.spring.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BestPractiseApplication.class, args);
        context.close();
    }
}

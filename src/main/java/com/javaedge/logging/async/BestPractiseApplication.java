package com.javaedge.logging.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JavaEdge
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        System.setProperty("logging.config", "classpath:com/javaedge/logging/async/asyncwrong.xml");
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}
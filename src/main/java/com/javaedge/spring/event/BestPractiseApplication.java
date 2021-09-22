package com.javaedge.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author JavaEdge
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}

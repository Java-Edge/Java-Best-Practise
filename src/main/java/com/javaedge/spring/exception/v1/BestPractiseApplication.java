package com.javaedge.spring.exception.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 过滤器异常
 *
 * @author JavaEdge
 * @date 2021/10/17
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}

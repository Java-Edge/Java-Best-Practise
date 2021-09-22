package com.javaedge.spring.filter.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Component + Filter接口 构建过滤器
 *
 * @author JavaEdge
 * @date 2021/10/17
 */
@SpringBootApplication
@Slf4j
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
        log.info("启动成功");
    }
}

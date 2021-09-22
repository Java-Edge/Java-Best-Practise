package com.javaedge.spring.filter.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ServletComponentScan + @WebFilter 构建过滤器
 *
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
        log.info("启动成功");
    }
}

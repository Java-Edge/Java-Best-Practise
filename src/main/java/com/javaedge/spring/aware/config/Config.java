package com.javaedge.spring.aware.config;

import com.javaedge.spring.aware.MyBeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JavaEdge
 * @date 2022/2/10
 */
@Configuration
public class Config {

    /**
     * 为我们的MyBeanName类明确指定了一个名称
     * @return
     */
    @Bean(name = "myCustomBeanName")
    public MyBeanName getMyBeanName() {
        return new MyBeanName();
    }
}

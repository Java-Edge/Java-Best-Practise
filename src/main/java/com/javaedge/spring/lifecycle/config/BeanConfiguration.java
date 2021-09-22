package com.javaedge.spring.lifecycle.config;

import com.javaedge.spring.lifecycle.service.LightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JavaEdge
 * @date 2021/9/14
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public LightService getTransmission() {
        return new LightService();
    }
}

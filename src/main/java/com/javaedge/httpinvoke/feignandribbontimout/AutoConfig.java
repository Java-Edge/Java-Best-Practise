package com.javaedge.httpinvoke.feignandribbontimout;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.javaedge.httpinvoke.feignandribbontimout")
public class AutoConfig {
}

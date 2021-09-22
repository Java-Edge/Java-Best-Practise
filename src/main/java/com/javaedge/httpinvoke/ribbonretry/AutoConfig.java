package com.javaedge.httpinvoke.ribbonretry;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "com.javaedge.httpinvoke.ribbonretry.feign")
public class AutoConfig {
}

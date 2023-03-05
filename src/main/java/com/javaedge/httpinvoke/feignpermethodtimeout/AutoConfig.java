package com.javaedge.httpinvoke.feignpermethodtimeout;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.javaedge.httpinvoke.feignpermethodtimeout")
public class AutoConfig {
}

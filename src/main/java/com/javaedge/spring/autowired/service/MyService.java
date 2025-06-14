package com.javaedge.spring.autowired.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
//@Service
public class MyService implements ClassX {

    private String myServiceName;

//    public MyService(String myServiceName) {
//        this.myServiceName = myServiceName;
//    }
//
//    public MyService(String myServiceName, String otherParam) {
//        this.myServiceName = myServiceName;
//    }

    public String sayHello() {
        return "hello Java";
    }

    // 该bean装配给MyService的构造器参数-myServiceName
//    @Bean
//    public String myServiceName() {
//        return "MyServiceName";
//    }
}

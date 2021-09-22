package com.javaedge.spring.autowired.controller;

import com.javaedge.spring.autowired.service.ClassX;
import com.javaedge.spring.autowired.service.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@RestController
public class MyController {

//    @Autowired
//    private ApplicationContext applicationContext;
//    @Autowired
//    private JavaService javaService;

    @Autowired
    private ClassX classX;

    @GetMapping("hello")
    public String hello() {
        return "hello: " + getJavaService();
    }

    @Lookup
    public JavaService getJavaService() {
//        return applicationContext.getBean(JavaService.class);
        return null;
    }
}

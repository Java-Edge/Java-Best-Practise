package com.javaedge.spring.filter.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JavaEdge
 * @date 2021/10/14
 */
@Controller
@Slf4j
public class UserController {
// 错误写法
//    @Autowired
//    private TimeCostFilter timeCostFilter
    @Autowired
    @Qualifier("com.javaedge.spring.filter.v1.TimeCostFilter")
    FilterRegistrationBean timeCostFilter;

    @GetMapping("/reg/{name}")
    @ResponseBody
    public String saveUser(String name) {
        log.info("注册成功");
        return "success";
    }
}

package com.javaedge.spring.filter.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JavaEdge
 * @date 2021/10/17
 */
@Controller
@Slf4j
public class UserController {

    @GetMapping("/reg/{name}")
    @ResponseBody
    public String saveUser(String name) {
        log.info("register success!");
        return "OK";
    }
}

package com.javaedge.spring.rest.v1;

import org.springframework.web.bind.annotation.*;

/**
 * @author JavaEdge
 * @date 2021/11/24
 */
@RestController
public class HelloWorldController {
    @PostMapping(path = "java")
    public String java(@RequestParam("para1") String para1, @RequestParam("para2") String para2) {
        return "JavaEdge:" + para1 + "," + para2;
    }
}

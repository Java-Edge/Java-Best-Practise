package com.javaedge.spring.rest.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JavaEdge
 * @date 2021/11/24
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "java")
    public String java(@RequestParam("p1") String p1) {
        return "JavaEdge:" + p1;
    }

}

package com.javaedge.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 就是要处理ContextStartedEvent
 *
 * @author JavaEdge
 * @date 2022/3/27
 */
@RestController
public class EventController {

    @Autowired
    private AbstractApplicationContext applicationContext;

    @GetMapping(path = "publishEvent")
    public String notifyEvent() {
        applicationContext.start();
        return "ok";
    }
}

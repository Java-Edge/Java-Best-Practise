package com.javaedge.spring.event.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEventListenerController {

    @Autowired
    private MyTestEventPublisher publisher;

    @RequestMapping(value = "/test/testPublishEvent1")
    public void testPublishEvent() {
        publisher.pushListener("我来了！");
    }
}

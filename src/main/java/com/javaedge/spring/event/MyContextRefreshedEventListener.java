package com.javaedge.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * 定义了一个监听器，拦截ContextStartedEvent
 * @author JavaEdge
 * @date 2022/3/27
 */
//@Slf4j
//@Component
//public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {
//
//    @Override
//    public void onApplicationEvent(final ContextStartedEvent event) {
//        log.info("{} received: {}", this.toString(), event);
//    }
//
//}

@Slf4j
@Component
public class MyContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        log.info("{} received: {}", this.toString(), event);
    }

}

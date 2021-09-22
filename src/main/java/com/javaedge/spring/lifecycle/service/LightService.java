package com.javaedge.spring.lifecycle.service;

import org.springframework.stereotype.Service;

/**
 * @author JavaEdge
 * @date 2021/9/13
 */
@Service
public class LightService {

    public void shutdown() {
        System.out.println("turn off all lights");
    }

    public void start() {
        System.out.println("turn on all lights");
    }

    public void check() {
        System.out.println("check all lights");
    }
}

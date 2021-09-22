package com.javaedge.spring.aop.controller;

import com.javaedge.spring.aop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@RestController
public class GameController {

    @Autowired
    CouponService couponService;

    @GetMapping(path = "deposit")
    public void deposit() throws Exception {
        couponService.deposit();
    }
}

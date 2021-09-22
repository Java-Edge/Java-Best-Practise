package com.javaedge.spring.aop.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@Service
public class CouponService {

//    @Autowired
//    CouponService couponService;

    @Autowired
    private AdminUserService adminUserService;

    public void deposit() throws Exception {
        System.out.println("Coupon depositing ...");
         this.pay();
        CouponService couponService = ((CouponService) AopContext.currentProxy());
        couponService.pay();
    }

    public void pay() throws Exception {
        adminUserService.login();
//        String payNum = adminUserService.admin.getPayNum();
        String payNum = adminUserService.getUser().getPayNum();
        System.out.println("User pay num : " + payNum);
        System.out.println("Pay with WeChat Pay ...");
        // 模拟pay()方法调用耗时
        Thread.sleep(1000);
    }
}

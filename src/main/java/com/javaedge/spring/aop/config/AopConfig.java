package com.javaedge.spring.aop.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@Aspect
@Service
@Slf4j
public class AopConfig {

    @Before("execution(* com.javaedge.spring.aop.service.AdminUserService.login(..)) ")
    public void logAdminLogin(JoinPoint pjp) throws Throwable {
        System.out.println("admin login ...");
    }

    @Around("execution(* com.javaedge.spring.aop.service.CouponService.pay()) ")
    public Object recordPayPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        long start = System.currentTimeMillis();
        result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Pay method time cost（ms）: " + (end - start));
        return result;
    }
}

package com.javaedge.spring.filter.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 计算注册学生的执行耗时，需要包括授权过程
 *
 * @author JavaEdge
 * @date 2021/10/18
 */
//@WebFilter 不用即可
@Slf4j
@Order(1)
public class TimeCostFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("#开始计算接口耗时");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("#执行时间(ms)：" + time);
    }
}

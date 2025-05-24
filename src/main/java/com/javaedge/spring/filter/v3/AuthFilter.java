package com.javaedge.spring.filter.v3;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 限制特定IP地址段（如你的办公网）的用户方可注册为新用户，Sleep模拟过程。
 *
 * @author JavaEdge
 * @date 2021/10/18
 */
@WebFilter
@Slf4j
@Order(2)
public class AuthFilter implements Filter {

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (isPassAuth()) {
            log.info("通过授权");
            chain.doFilter(request, response);
        } else {
            log.info("未通过授权");
            ((HttpServletResponse) response).sendError(401);
        }
    }

    private boolean isPassAuth() throws InterruptedException {
        log.info("执行检查权限");
        Thread.sleep(1000);
        return true;
    }
}
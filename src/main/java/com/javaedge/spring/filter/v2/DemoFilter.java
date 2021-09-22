package com.javaedge.spring.filter.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author JavaEdge
 * @date 2021/10/17
 */
@Component
@Slf4j
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // 模拟异常
            log.info("Exception occurs when filter");
            throw new RuntimeException();
        } catch (Exception e) {
//            chain.doFilter(request, response); 移除该行即不会再重复执行业务方法
        }
        chain.doFilter(request, response);
    }
}

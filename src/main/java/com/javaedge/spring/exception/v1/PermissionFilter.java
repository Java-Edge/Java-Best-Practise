package com.javaedge.spring.exception.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JavaEdge
 * @date 2021/10/24
 */
@WebFilter
@Component
@Slf4j
public class PermissionFilter implements Filter {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        if (!"JavaEdge".equals(token)) {
            log.info("throw IllegalRequestException");
            resolver.resolveException(httpServletRequest, httpServletResponse, null,
                    new IllegalRequestException());
            return;
        }
        chain.doFilter(request, response);
    }
}

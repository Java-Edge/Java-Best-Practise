package com.javaedge.spring.filter.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author JavaEdge
 * @date 2021/10/14
 */
@WebFilter
@Slf4j
public class TimeCostFilter implements Filter {

    public TimeCostFilter() {
        log.info("构造器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        StopWatch sw = new StopWatch();
        sw.start();
        chain.doFilter(request, response);
        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
    }
}

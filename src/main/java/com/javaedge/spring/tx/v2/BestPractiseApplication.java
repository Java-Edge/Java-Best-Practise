package com.javaedge.spring.tx.v2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author JavaEdge
 * @date 2021/11/22
 */
@Configuration
@ComponentScan
@Import({JdbcConfig.class})
@PropertySource("classpath:application.properties")
@MapperScan("com.javaedge.spring.tx.v2")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class BestPractiseApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(BestPractiseApplication.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.saveUser("JavaEdge");
    }
}

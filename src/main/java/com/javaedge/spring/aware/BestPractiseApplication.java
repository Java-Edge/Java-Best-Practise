package com.javaedge.spring.aware;

import com.javaedge.spring.aware.config.Config;
import com.javaedge.spring.aware.service.BeanLifeCircleService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        MyBeanName myBeanName = context.getBean(MyBeanName.class);
    }
}

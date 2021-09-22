package com.javaedge.spring.value.config;

import com.javaedge.spring.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author JavaEdge
 * @date 2021/9/12
 */
//@Configuration
public class SomeConfig {

    @Value("#{student}")
    private User user;

    /**
     * user Bean 定义
     *
     * @return user 实例
     */
    @Bean
    public User student() {
        return new User(1, "JavaEdge");
    }

    // 注册常规的字符串
    @Value("我是个儿字符串")
    private String text;

    // 可注入：
    //  系统参数
    //  环境变量
    //  配置文件
    @Value("${ip}")
    private String ip;

    /**
     * 注入其他Bean属性
     * user 为 bean的ID
     * name    为 其属性
     */
    @Value("#{student.name}")
    private String name;
}

package com.javaedge.spring.value.config;

import com.javaedge.spring.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author JavaEdge
 * @date 2021/9/12
 */
@Configuration
public class UserConfig {

    @Bean
    public User user1() {
        return createUser(1, "java");
    }

    @Bean
    public User user2() {
        return createUser(2, "edge");
    }

    private User createUser(int id, String name) {
        return new User(id, name);
    }

    @Bean
    public User user3() {
        return createUser(3, "WeChat");
    }

    @Bean
    public User user4() {
        return createUser(4, "QQ");
    }


    @Bean
    public List<User> users() {
//        User user1 = createUser(1, "java");
//        User user2 = createUser(2, "edge");
        User user3 = createUser(3, "WeChat");
        User user4 = createUser(4, "QQ");
        return Arrays.asList(/*user1, user2,*/ user3, user4);
    }
}

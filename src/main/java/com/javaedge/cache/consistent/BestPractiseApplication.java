package com.javaedge.cache.consistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author JavaEdge
 */
@SpringBootApplication
public class BestPractiseApplication {

    BestPractiseApplication(RedisTemplate redisTemplate,
                            StringRedisTemplate stringRedisTemplate) {
        String key = "myK";
        stringRedisTemplate.opsForValue().set(key, "myV");

        Object valueGotFromStringRedisTemplate = stringRedisTemplate.opsForValue().get(key);
        System.out.println(valueGotFromStringRedisTemplate);

        Object valueGotFromRedisTemplate = redisTemplate.opsForValue().get(key);
        System.out.println(valueGotFromRedisTemplate);
    }

    public static void main(String[] args) {
        SpringApplication.run(BestPractiseApplication.class, args);
    }
}


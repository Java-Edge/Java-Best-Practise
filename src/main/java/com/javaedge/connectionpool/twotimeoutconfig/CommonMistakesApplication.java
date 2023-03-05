package com.javaedge.connectionpool.twotimeoutconfig;

import com.javaedge.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        Utils.loadPropertySource(CommonMistakesApplication.class, "hikari.properties");

        SpringApplication.run(CommonMistakesApplication.class, args);
    }

}


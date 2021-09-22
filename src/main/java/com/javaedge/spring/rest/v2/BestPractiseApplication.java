package com.javaedge.spring.rest.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * URL 含有特殊字符
 *
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BestPractiseApplication.class, args);

        String url = "http://localhost:12345/java?para1=1#2";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode().toUri();

        HttpEntity<?> entity = new HttpEntity<>(null);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());

        context.close();
    }
}

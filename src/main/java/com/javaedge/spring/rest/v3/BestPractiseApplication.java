package com.javaedge.spring.rest.v3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 多次 URL Encoder
 *
 * @author JavaEdge
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BestPractiseApplication.class, args);

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:12345/java");
        builder.queryParam("p1", "dev 666");
//        String url = builder.toUriString();
        URI url = builder.encode().build().toUri();
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());

        context.close();
    }
}

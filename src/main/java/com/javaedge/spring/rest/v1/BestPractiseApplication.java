package com.javaedge.spring.rest.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BestPractiseApplication.class, args);

        RestTemplate template = new RestTemplate();
//        Map<String, Object> paramMap = new HashMap<>(4);
//        paramMap.put("para1", "001");
//        paramMap.put("para2", "002");
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("para1", "001");
        paramMap.add("para2", "002");

        String url = "http://localhost:12345/java";
        String result = template.postForObject(url, paramMap, String.class);
        System.out.println(result);

        context.close();
    }
}

package com.javaedge.nullvalue.npe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JavaEdge
 */
@RestController
@RequestMapping("npe")
@Slf4j
public class NpeController {

    @GetMapping("bad")
    public int bad(@RequestParam(value = "test", defaultValue = "1111") String test) {
        return bad(test.charAt(0) == '1' ? null : new MyService(),
                test.charAt(1) == '1' ? null : 1,
                test.charAt(2) == '1' ? null : "OK",
                test.charAt(3) == '1' ? null : "OK").size();
    }

    @GetMapping("right")
    public int right(@Nullable @RequestParam(value = "test", defaultValue = "1111") String test) {
        return Optional
                .ofNullable(good(test.charAt(0) == '1' ? null : new MyService(),
                        test.charAt(1) == '1' ? null : 1,
                        test.charAt(2) == '1' ? null : "Java!",
                        test.charAt(3) == '1' ? null : "Java!"))
                .orElse(Collections.emptyList()).size();
    }

    private List<String> bad(MyService myService, Integer i, String s, String t) {
        log.info("result {} {} {} {}",
                i + 1,
                "OK".equals(s),
                s.equals(t),
                new ConcurrentHashMap<String, String>().put(null, null));

        if ("OK".equals(myService.getFooService().foo())) {
            log.info("OK");
        }
        return null;
    }

    private List<String> good(MyService myService, Integer i, String s, String t) {
        log.info("result {} {} {} {}", Optional.ofNullable(i).orElse(0) + 1,
                "OK".equals(s), Objects.equals(s, t),
                new HashMap<String, String>(16).put(null, null));

        Optional.ofNullable(myService)
                .map(MyService::getFooService)
                .filter(fooService -> "OK".equals(fooService.foo()))
                .ifPresent(result -> log.info("OK"));
        return new ArrayList<>();
    }

    class MyService {

        @Getter
        private FooService fooService;
    }

    class FooService {

        String foo() {
            return "OK";
        }
    }
}

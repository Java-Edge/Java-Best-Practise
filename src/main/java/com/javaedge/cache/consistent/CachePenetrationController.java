package com.javaedge.cache.consistent;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author JavaEdge
 */
@Slf4j
@RequestMapping("localcache")
@RestController
public class CachePenetrationController {

    public void loadingCache() {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) {
                        if ("key".equals(key)) {
                            return "key return result";
                        } else {
                            return "get-if-absent-compute";
                        }
                    }
                });
        String resultVal = null;
        try {
            resultVal = graphs.get("key");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void callable() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).build();
        String result = cache.get("key", () -> "result");
        System.out.println(result);
    }
}

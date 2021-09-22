package com.javaedge.spring.lifecycle.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JavaEdge
 * @date 2021/9/7
 */
@Component
public class LightMgrService implements InitializingBean {

    @Autowired
    private LightService lightService;

    @Override
    public void afterPropertiesSet() throws Exception {
        lightService.check();
    }

//    @PostConstruct
//    public void init() {
//        lightService.check();
//    }

//    public LightMgrService(LightService lightService) {
//        this.lightService = lightService;
//        lightService.check();
//    }

}

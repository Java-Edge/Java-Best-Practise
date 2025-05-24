package com.javaedge.drools.service;

import com.javaedge.drools.model.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单服务类
 *
 * @author JavaEdge
 */
@Service
public class OrderService {

    @Autowired
    private KieSession kieSession;

    /**
     * 处理订单
     * 执行规则引擎，计算订单的积分和折扣
     *
     * @param order 订单信息
     * @return 处理后的订单信息
     */
    public Order processOrder(Order order) {
        try {
            // 将订单信息插入到规则引擎中
            kieSession.insert(order);
            // 触发所有规则
            kieSession.fireAllRules();
            return order;
        } finally {
            // 清空会话中的数据，避免重复执行
            kieSession.dispose();
        }
    }
}

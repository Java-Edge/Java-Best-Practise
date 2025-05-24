package com.javaedge.drools;

import com.javaedge.drools.model.Order;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Drools规则引擎示例
 *
 * @author JavaEdge
 */
public class DroolsExample {

    public static void main(String[] args) {
        try {
            // 获取KieServices
            KieServices kieServices = KieServices.Factory.get();
            // 获取KieContainer
            KieContainer kieContainer = kieServices.getKieClasspathContainer();
            // 从KieContainer中获取KieSession
            KieSession kieSession = kieContainer.newKieSession("ksession-rules");

            // 测试不同类型和金额的订单
            testOrder(kieSession, new Order(1200, "NORMAL"));
            testOrder(kieSession, new Order(1200, "VIP"));
            testOrder(kieSession, new Order(800, "NORMAL"));
            testOrder(kieSession, new Order(800, "VIP"));
            testOrder(kieSession, new Order(300, "NORMAL"));
            testOrder(kieSession, new Order(300, "VIP"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testOrder(KieSession kieSession, Order order) {
        System.out.println("==================================================");
        System.out.println("测试订单：金额 = " + order.getAmount() + ", 类型 = " + order.getType());

        // 将订单插入到规则引擎中
        kieSession.insert(order);
        // 触发所有规则
        kieSession.fireAllRules();

        // 输出处理结果
        System.out.println("处理结果：" + order);
        System.out.println("==================================================");
    }
}

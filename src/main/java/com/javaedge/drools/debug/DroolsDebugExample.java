package com.javaedge.drools.debug;

import com.javaedge.drools.model.Order;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Drools规则调试示例
 * 展示如何调试规则文件
 *
 * @author JavaEdge
 */
public class DroolsDebugExample {
    private static final Logger logger = LoggerFactory.getLogger(DroolsDebugExample.class);

    public static void main(String[] args) {
        // 获取KieServices和KieContainer
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        // 创建KieSession
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");

        // 1. 添加Drools提供的调试监听器
        // 这将输出规则执行的详细信息
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());
        kieSession.addEventListener(new DebugAgendaEventListener());

        // 2. 设置系统属性以启用Drools的调试模式
        System.setProperty("drools.debugMode", "true");

        try {
            // 创建测试订单
            Order order = new Order(1200, "VIP");
            logger.info("开始处理订单: {}", order);

            // 3. 在插入事实对象之前设置断点
            kieSession.insert(order);  // <-- 可以在这里设置断点

            // 4. 在执行规则之前设置断点
            logger.info("准备执行规则...");
            int firedRules = kieSession.fireAllRules();  // <-- 可以在这里设置断点

            logger.info("规则执行完成，触发了 {} 条规则", firedRules);
            logger.info("处理后的订单: {}", order);

        } finally {
            kieSession.dispose();
        }
    }

    /**
     * 使用单个规则进行调试
     * 这个方法展示了如何单独测试某个规则
     */
    public static void debugSingleRule() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");

        try {
            // 创建一个符合特定规则条件的订单
            Order order = new Order(1200, "VIP");
            logger.info("测试VIP订单规则 - 初始订单: {}", order);

            kieSession.insert(order);

            // 5. 使用规则过滤器，只执行特定的规则
            int firedRules = kieSession.fireAllRules(match ->
                match.getRule().getName().equals("score-rule-4"));

            logger.info("VIP规则测试完成，触发了 {} 条规则", firedRules);
            logger.info("处理后的订单: {}", order);

        } finally {
            kieSession.dispose();
        }
    }
}

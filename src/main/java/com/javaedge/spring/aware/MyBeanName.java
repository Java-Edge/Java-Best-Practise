package com.javaedge.spring.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author JavaEdge
 * @date 2022/2/10
 */
public class MyBeanName implements BeanNameAware {

    /**
     * beanName属性表示在Spring容器中注册的bean id
     * 在本案例实现中，我们只显示bean名称
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        System.out.println(beanName);
    }
}

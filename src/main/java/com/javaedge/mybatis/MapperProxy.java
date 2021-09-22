package com.javaedge.mybatis;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JavaEdge
 * @date 1/25/23
 */
@Slf4j
public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                // 如hashCode()、toString()、equals()等方法，将target指向当前对象this
                return method.invoke(this, args);
            } catch (Throwable t) {
                log.error("invoke error", t);
            }
        }
        // 投鞭断流
        return new User((Integer) args[0], "JavaEdge", 18);
    }
}

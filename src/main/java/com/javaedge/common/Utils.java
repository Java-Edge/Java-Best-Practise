package com.javaedge.common;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class Utils {

    public static void loadPropertySource(Class clazz,String fileName){
        try {
            Properties p=new Properties();
            p.load(clazz.getResourceAsStream(fileName));
            p.forEach((k,v)->{
                log.info("{}={}",k,v);
                System.setProperty(k.toString(),v.toString());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NoArgsConstructor
    static class Foo {

    }
    public static void main(String[] args) {
        Foo foo = new Foo();
    }
}

package com.javaedge.spring.tx.v4;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value();

    String core = "core";

    String card = "card";
}
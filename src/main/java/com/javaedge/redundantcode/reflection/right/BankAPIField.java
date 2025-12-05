package com.javaedge.redundantcode.reflection.right;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {

    /**
     * 参数的次序
     * @return
     */
    int order() default -1;

    /**
     * 长度
     * @return
     */
    int length() default -1;

    /**
     * 类型
     * @return
     */
    String type() default "";
}

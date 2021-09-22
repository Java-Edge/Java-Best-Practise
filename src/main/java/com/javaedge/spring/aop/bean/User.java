package com.javaedge.spring.aop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JavaEdge
 * @date 2021/9/20
 */
@AllArgsConstructor
@Data
public class User {

    /**
     * 用户的付款编号
     */
    private String payNum;
}

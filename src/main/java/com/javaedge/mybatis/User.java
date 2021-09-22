package com.javaedge.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author JavaEdge
 * @date 1/25/23
 */
@Data
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private int age;
}

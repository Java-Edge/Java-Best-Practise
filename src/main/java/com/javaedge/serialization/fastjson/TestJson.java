package com.javaedge.serialization.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @author JavaEdge
 * @date 2022/9/28
 */
public class TestJson {
    public static void main(String[] args) {
        Object parse = JSONObject.parse("12345678");
        System.out.println(parse + ", classType: " + parse.getClass());

        Object parse1 = JSONObject.parse("A12345678");
        System.out.println(parse1 + ", classType: " + parse1.getClass());
    }
}

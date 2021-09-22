package com.javaedge.collection.set;

import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Set转逗号分隔字符串
 *
 * @author JavaEdge
 * @date 2021/10/8
 */
public class Set2String {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Edge");
        set.add("公众号");
        System.out.println(set);

        Object[] array = set.toArray();
        String splitSet = StringUtils.join(array);
        System.out.println("splitSet:" + splitSet);

        String splitSetWithComma = StringUtils.join(array, ",");
        System.out.println("splitSetWithComma:" + splitSetWithComma);
    }
}

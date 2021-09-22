package com.javaedge.collection.set;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author JavaEdge
 * @date 2021/9/3
 */
public class Demo {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 10));
        userList.add(new User("李四", 23));
        userList.add(new User("张三", 78));
        userList.add(new User("张三", 10));

        // 使用HashSet,无序
        Set<User> userSet = new HashSet<>(userList);
        System.out.println("源集合元素：" + userSet);

        // 使用LinkedHashSet，有序
        List<User> listNew = new ArrayList<>(new LinkedHashSet<>(userList));
        System.out.println("有序集合元素：" + listNew.toString());

        // 根据name属性去重
        List<User> uniqueNameList = userList
                .stream()
                .collect(collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(User::getName))), ArrayList::new)
                );

        System.out.println("根据name去重后集合元素：" + uniqueNameList.toString());

        // 根据name,age属性去重
        List<User> uniqueNameAndAgeList = userList
                .stream()
                .collect(collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(o -> o.getName() + ";" + o.getAge()))), ArrayList::new)
                );

        System.out.println("根据name,age去重后集合元素：" + uniqueNameAndAgeList.toString());
    }
}

package com.javaedge.java8.streams;

import java.util.stream.Stream;

/**
 * @author JavaEdge
 * @date 2021/9/6
 */
public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);
    }
}

package com.javaedge.java8.streams;

import java.util.stream.Stream;

/**
 * @author JavaEdge
 * @date 2021/9/6
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}

package com.javaedge.java8.streams;

/**
 * @author JavaEdge
 * @date 2021/9/6
 */
public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream("Cheese.dat")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}

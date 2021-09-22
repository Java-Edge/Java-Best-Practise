package com.javaedge.oom.gc.old;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JavaEdge
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) {
//        byte[] data1 = new byte[2 * 1024 * 1024];
//        data1 = new byte[2 * 1024 * 1024];
//        data1 = new byte[2 * 1024 * 1024];
//        data1 = null;
//
//        byte[] data2 = new byte[128 * 1024];
//
//        byte[] data3 = new byte[2 * 1024 * 1024];
//
//        data3 = new byte[2 * 1024 * 1024];
//        data3 = new byte[2 * 1024 * 1024];
//        data3 = new byte[128 * 1024];
//        data3 = null;
//
//        byte[] data4 = new byte[2 * 1024 * 1024];

        byte[] data1 = new byte[2 * 1024 * 1024];
        data1 = new byte[2 * 1024 * 1024];
        data1 = new byte[2 * 1024 * 1024];

        byte[] data2 = new byte[128 * 1024];
        data2 = null;

        byte[] data3 = new byte[2 * 1024 * 1024];
    }


}


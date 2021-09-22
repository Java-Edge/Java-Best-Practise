package com.javaedge.oom.gc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JavaEdge
 */
@SpringBootApplication
public class BestPractiseApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }
        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];
        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];
        // 每s执行一次loadData()
        Thread.sleep(1000);
    }
}


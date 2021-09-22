package com.javaedge.concurrency;

/**
 * @author JavaEdge
 */
public class InterferingTask implements Runnable {

    final int id;

    private static Integer val = 0;

    public InterferingTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
    }
}

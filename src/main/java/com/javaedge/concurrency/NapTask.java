package com.javaedge.concurrency;

/**
 * 创建任务
 *
 * @author JavaEdge
 */
public class NapTask implements Runnable {

    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " +
                Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask[" + id + "]";
    }
}

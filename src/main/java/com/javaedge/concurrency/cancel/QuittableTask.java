package com.javaedge.concurrency.cancel;

import com.javaedge.concurrency.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author JavaEdge
 */
public class QuittableTask implements Runnable {

    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        // 只要运行标志为true，该任务的run()方法将继续
        while (running.get()) {
            new Nap(0.1);
        }
        // 显示，仅在任务退出时才发生
        System.out.print(id + " ");
    }
}

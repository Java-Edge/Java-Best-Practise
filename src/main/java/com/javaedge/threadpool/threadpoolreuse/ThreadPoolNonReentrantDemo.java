package com.javaedge.threadpool.threadpoolreuse;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolNonReentrantDemo {
    // 用于记录任务序号
    private static final AtomicInteger taskId = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 核心线程数为2，最大线程数为2，队列容量为3
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // corePoolSize
                2, // maximumPoolSize
                0L, TimeUnit.MILLISECONDS, // keepAliveTime
                new LinkedBlockingQueue<>(3), // workQueue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // outerTask 是一个外部任务，打印当前线程名和任务 ID，模拟 1 秒的执行时间。
        // 提交一个任务，该任务会尝试再次提交新任务
        Runnable outerTask = () -> {
            String currentThreadName = Thread.currentThread().getName();
            int currentTaskId = taskId.incrementAndGet();
            System.out.println("Outer Task " + currentTaskId + " is running in thread: " + currentThreadName);

            // 模拟任务执行耗时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /**
             * 在 outerTask 中，提交一个 innerTask 到同一个线程池。
             * 打印自己的线程名和任务 ID，模拟 0.5 秒的执行时间。
             *
             * 预期行为：
             * 当 outerTask 执行时，它提交的 innerTask 不会由当前线程直接执行。
             * innerTask 要么被放入队列等待，要么被分配给线程池中的其他可用线程（如果有）。
             */
            // 尝试再次提交一个新任务到同一个线程池
            Runnable innerTask = () -> {
                String innerThreadName = Thread.currentThread().getName();
                int innerTaskId = taskId.incrementAndGet();
                // 日志会显示 outerTask 和 innerTask 运行在不同线程或按队列顺序执行，证明线程池的不可重入特性
                System.out.println("Inner Task " + innerTaskId + " is running in thread: " + innerThreadName);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 日志显示 outerTask、innerTask 运行在不同线程或按队列顺序执行，证明线程池不可重入
                System.out.println("Inner Task " + innerTaskId + " finished in thread: " + innerThreadName);
            };
            // 日志显示 outerTask、innerTask 运行在不同线程或按队列顺序执行，证明线程池不可重入
            System.out.println("Outer Task " + currentTaskId + " submitting Inner Task...");
            executor.execute(innerTask);
            // 日志显示 outerTask、innerTask 运行在不同线程或按队列顺序执行，证明线程池不可重入
            System.out.println("Outer Task " + currentTaskId + " finished in thread: " + currentThreadName);
        };

        // 提交多个任务以观察线程池行为
        for (int i = 0; i < 3; i++) {
            executor.execute(outerTask);
        }

        // 等待一段时间以观察输出
        Thread.sleep(5000);

        // 关闭线程池
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Thread pool terminated.");
    }
}
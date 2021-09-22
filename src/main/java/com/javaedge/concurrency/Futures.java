package com.javaedge.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author JavaEdge
 */
public class Futures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<Integer> f = exec.submit(new CountingTask(99));

        // 当你的任务尚未完成的Future上调用get()时，调用会阻塞（等待）直到结果可用
        System.out.println(f.get());
        exec.shutdown();
    }
}
/* Output:
99 pool-1-thread-1 100
100
*/

package com.javaedge.concurrency;

import java.util.concurrent.*;
import java.util.stream.*;

/**
 * 非线程安全
 *
 * @author JavaEdge
 */
public class CachedThreadPool2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
/* Output:
0 pool-1-thread-1 195
3 pool-1-thread-4 400
2 pool-1-thread-3 300
1 pool-1-thread-2 200
5 pool-1-thread-6 600
6 pool-1-thread-7 700
4 pool-1-thread-5 500
7 pool-1-thread-3 800
8 pool-1-thread-5 900
9 pool-1-thread-7 1000
*/
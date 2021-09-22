package com.javaedge.concurrency;

import java.util.stream.IntStream;

/**
 * @author JavaEdge
 */
public class CountingStream {

    public static void main(String[] args) {
        System.out.println(IntStream.range(0, 10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(CountingTask::call)
                .reduce(0, Integer::sum));
    }
}
/* Output:
4 ForkJoinPool.commonPool-worker-15 100
1 ForkJoinPool.commonPool-worker-11 100
5 ForkJoinPool.commonPool-worker-1 100
2 ForkJoinPool.commonPool-worker-9 100
0 ForkJoinPool.commonPool-worker-6 100
3 ForkJoinPool.commonPool-worker-8 100
9 ForkJoinPool.commonPool-worker-13 100
6 main 100
8 ForkJoinPool.commonPool-worker-2 100
7 ForkJoinPool.commonPool-worker-4 100
1000
*/

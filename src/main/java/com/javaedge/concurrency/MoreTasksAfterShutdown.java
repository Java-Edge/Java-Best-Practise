package com.javaedge.concurrency;

import java.util.concurrent.*;

/**
 * @author JavaEdge
 */
public class MoreTasksAfterShutdown {

    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        exec.execute(new NapTask(1));
        exec.shutdown();
        try {
            exec.execute(new NapTask(99));
        } catch (RejectedExecutionException e) {
            System.out.println(e);
        }
    }
}
/* Output:
java.util.concurrent.RejectedExecutionException: Task
NapTask[99] rejected from java.util.concurrent.ThreadPo
olExecutor@106d69c[Shutting down, pool size = 1, active
threads = 1, queued tasks = 0, completed tasks = 0]
NapTask[1] pool-1-thread-1
*/

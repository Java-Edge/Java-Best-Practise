package com.javaedge.java8.completablefuture.transfer;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author JavaEdge
 * @date 2022/1/22
 */
public class Client {

    @Resource
    private TransferService transferService;

    private final static int A = 1000;

    private final static int B = 1001;

    public void syncInvoke() throws ExecutionException, InterruptedException {
        // 同步调用
        transferService.transfer(A, B, 100).get();
        System.out.println("转账完成！");
    }

    public void asyncInvoke() {
        // 异步调用
        transferService.transfer(A, B, 100)
                .thenRun(() -> System.out.println("转账完成！"));
    }
}

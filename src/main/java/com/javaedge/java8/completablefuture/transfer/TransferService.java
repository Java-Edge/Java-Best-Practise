package com.javaedge.java8.completablefuture.transfer;

import java.util.concurrent.CompletableFuture;

/**
 * 转账服务
 *
 * @author JavaEdge
 * @date 2022/1/22
 */
public interface TransferService {

    /**
     * 异步转账服务
     *
     * @param fromAccount 转出账户
     * @param toAccount 转入账户
     * @param amount 转账金额，单位分
     */
    CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount);
}

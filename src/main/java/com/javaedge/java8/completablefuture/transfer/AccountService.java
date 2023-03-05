package com.javaedge.java8.completablefuture.transfer;

import java.util.concurrent.CompletableFuture;

/**
 * 账户服务
 *
 * @author JavaEdge
 * @date 2022/1/22
 */
public interface AccountService {

    /**
     * 变更账户金额
     * @param account 账户ID
     * @param amount 增加的金额，负值为减少
     */
    CompletableFuture<Void> add(int account, int amount);
}

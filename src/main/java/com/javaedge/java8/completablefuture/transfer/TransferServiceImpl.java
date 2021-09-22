package com.javaedge.java8.completablefuture.transfer;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * 转账服务
 *
 * @author JavaEdge
 * @date 2022/1/22
 */
public class TransferServiceImpl implements TransferService {

    @Resource
    private AccountService accountService;

    @Override
    public CompletableFuture<Void> transfer(int from, int to, int amount) {
        // 异步调用add，从from账户扣减相应金额
        return accountService.add(from, -1 * amount)
                // 然后调用add，给to账户增加相应金额
                .thenCompose(v -> accountService.add(to, amount));
    }
}

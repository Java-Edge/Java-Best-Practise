package com.javaedge.asyncprocess.compensation;

import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class CompensationJob {

    // 补偿Job异步处理线程池
    private static final ThreadPoolExecutor compensationThreadPool = new ThreadPoolExecutor(
            10, 10,
            1, TimeUnit.HOURS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("compensation-threadpool-%d").get());
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;

    // 目前补偿到哪个用户ID
    private long offset = 0;

    // 10秒后开始补偿，5秒补偿一次
    @Scheduled(initialDelay = 10_000, fixedRate = 5_000)
    public void compensationJob() {
        log.info("开始从用户ID {} 补偿", offset);
        // 获取从offset开始的用户
        userService.getUsersAfterIdWithLimit(offset, 5).forEach(user -> {
            compensationThreadPool.execute(() -> memberService.welcome(user));
            offset = user.getId();
        });
    }
}
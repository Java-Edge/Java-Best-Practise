package com.javaedge.rsocket.client;

import com.javaedge.rsocket.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * RSocket客户端示例
 * 演示如何使用四种交互模式
 *
 * @author JavaEdge
 */
@Component
public class RSocketClient implements CommandLineRunner {

    private final RSocketRequester rSocketRequester;

    @Autowired
    public RSocketClient(RSocketRequester.Builder builder) {
        this.rSocketRequester = builder
                .connectTcp("localhost", 7000).block(); // 连接到RSocket服务器
    }

    @Override
    public void run(String... args) throws Exception {
        // 演示请求-响应模式
        this.requestResponse()
                .doOnNext(response -> System.out.println("请求-响应结果: " + response))
                .subscribe();

        // 演示请求-流模式
        this.requestStream()
                .doOnNext(response -> System.out.println("请求-流结果: " + response))
                .subscribe();

        // 演示即发-即忘模式
        this.fireAndForget()
                .subscribe(unused -> System.out.println("即发-即忘消息已发送"));

        // 演示通道模式
        this.channel()
                .doOnNext(response -> System.out.println("通道模式结果: " + response))
                .subscribe();

        // 为了让程序不立即退出
        Thread.sleep(15000);
    }

    /**
     * 请求-响应模式
     */
    public Flux<Message> requestResponse() {
        return rSocketRequester
                .route("request-response")
                .data(new Message("你好，RSocket", 0))
                .retrieveMono(Message.class)
                .flux();
    }

    /**
     * 请求-流模式
     */
    public Flux<Message> requestStream() {
        return rSocketRequester
                .route("request-stream")
                .data(new Message("流请求", 0))
                .retrieveFlux(Message.class);
    }

    /**
     * 即发-即忘模式
     */
    public Flux<Void> fireAndForget() {
        return Flux.range(1, 3)
                .delayElements(Duration.ofSeconds(1))
                .flatMap(i -> rSocketRequester
                        .route("fire-and-forget")
                        .data(new Message("即发即忘消息-" + i, i))
                        .send());
    }

    /**
     * 通道模式（双向流）
     */
    public Flux<Message> channel() {
        Flux<Message> requestFlux = Flux.interval(Duration.ofSeconds(1))
                .map(i -> new Message("通道消息-" + i, i))
                .take(5);

        return rSocketRequester
                .route("channel")
                .data(requestFlux)
                .retrieveFlux(Message.class);
    }
}

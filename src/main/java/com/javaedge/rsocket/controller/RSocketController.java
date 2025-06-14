package com.javaedge.rsocket.controller;

import com.javaedge.rsocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * RSocket服务器端控制器
 * 演示四种交互模式
 *
 * @author JavaEdge
 */
@Controller
public class RSocketController {

    /**
     * 请求-响应模式
     */
    @MessageMapping("request-response")
    public Mono<Message> requestResponse(Message request) {
        return Mono.just(new Message("响应: " + request.getParam(), 0));
    }

    /**
     * 请求-响应流模式
     */
    @MessageMapping("request-stream")
    public Flux<Message> requestStream(Message request) {
        return Flux
                .interval(Duration.ofSeconds(1))
                .map(index -> new Message(request.getParam(), index))
                .take(10); // 限制为10条消息
    }

    /**
     * 即发-即忘模式
     */
    @MessageMapping("fire-and-forget")
    public Mono<Void> fireAndForget(Message request) {
        System.out.println("收到即发即忘消息: " + request);
        return Mono.empty();
    }

    /**
     * 通道模式（双向流）
     */
    @MessageMapping("channel")
    public Flux<Message> channel(Flux<Message> requestFlux) {
        return requestFlux
                .doOnNext(message -> System.out.println("收到通道消息: " + message))
                .map(message -> new Message("回复: " + message.getParam(), message.getIndex()))
                .delayElements(Duration.ofSeconds(1));
    }
}

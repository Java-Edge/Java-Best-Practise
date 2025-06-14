package com.javaedge.rsocket.model;

import lombok.Data;

import java.time.Instant;

/**
 * 消息模型
 *
 * @author JavaEdge
 */
@Data
public class Message {
    private String param;
    private long index;
    private Instant timestamp;

    public Message() {
        this.timestamp = Instant.now();
    }

    public Message(String param, long index) {
        this.param = param;
        this.index = index;
        this.timestamp = Instant.now();
    }
}

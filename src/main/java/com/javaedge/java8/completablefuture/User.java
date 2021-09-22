package com.javaedge.java8.completablefuture;

import lombok.Builder;
import lombok.Data;

/**
 * @author JavaEdge
 */
@Data
@Builder
public class User {

    private Long id;

    private Boolean vip;
}

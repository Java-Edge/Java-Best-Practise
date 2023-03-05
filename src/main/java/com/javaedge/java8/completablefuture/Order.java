package com.javaedge.java8.completablefuture;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * @author JavaEdge
 */
@Data
@RequiredArgsConstructor
public class Order {

    private final Long id;

    private final String from;

    private final String to;

    private final Long userId;

    private final Long merchantId;

    private final Long couponId;

    private final BigDecimal itemPrice;

    private User user;

    private Merchant merchant;

    private BigDecimal couponPrice;

    private BigDecimal orderPrice;

    private BigDecimal deliverPrice;

    private BigDecimal totalPrice;
}

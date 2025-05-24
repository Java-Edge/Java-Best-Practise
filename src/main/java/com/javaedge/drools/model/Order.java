package com.javaedge.drools.model;

/**
 * 订单实体类，用于演示Drools规则引擎
 *
 * @author JavaEdge
 */
public class Order {
    private Integer amount; // 订单金额
    private Integer score; // 积分
    private String type; // 订单类型
    private Integer discount; // 折扣

    public Order() {
    }

    public Order(Integer amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", score=" + score +
                ", type='" + type + '\'' +
                ", discount=" + discount +
                '}';
    }
}

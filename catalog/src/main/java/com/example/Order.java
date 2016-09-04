package com.example;

public class Order {

    private final long id;
    private final String name;
    private final String paymentStatus;

    public Order(long id, String name, String paymentStatus) {
        this.id = id;
        this.name = name;
        this.paymentStatus = paymentStatus;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}

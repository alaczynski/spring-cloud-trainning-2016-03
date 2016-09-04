package com.example;

public class PaymentServiceFallback implements PaymentService {
    @Override
    public PaymentStatus payments() {
        return new PaymentStatus("OK from fallback");
    }
}

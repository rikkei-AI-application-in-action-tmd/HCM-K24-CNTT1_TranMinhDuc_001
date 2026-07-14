package com.rikkei.refactoring.strategy;
import org.springframework.stereotype.Component;

@Component
public class VnPayPaymentStrategy implements PaymentStrategy {
    @Override
    public String getMethodName() {
        return "VNPAY";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Connecting to VNPay API to pay amount: " + amount);
    }
}

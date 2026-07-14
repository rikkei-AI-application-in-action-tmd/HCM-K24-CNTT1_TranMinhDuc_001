package com.rikkei.refactoring.strategy;
import org.springframework.stereotype.Component;

@Component
public class MomoPaymentStrategy implements PaymentStrategy {
    @Override
    public String getMethodName() {
        return "MOMO";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Connecting to Momo API to pay amount: " + amount);
    }
}

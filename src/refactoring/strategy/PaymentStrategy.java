package com.rikkei.refactoring.strategy;

public interface PaymentStrategy {
    String getMethodName();
    void processPayment(double amount);
}

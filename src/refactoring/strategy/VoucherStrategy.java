package com.rikkei.refactoring.strategy;

public interface VoucherStrategy {
    boolean isApplicable(String voucherCode);
    double applyDiscount(double total);
}

package com.rikkei.refactoring.strategy;
import org.springframework.stereotype.Component;

@Component
public class FreeshipVoucherStrategy implements VoucherStrategy {
    @Override
    public boolean isApplicable(String voucherCode) {
        return voucherCode != null && voucherCode.startsWith("FREESHIP");
    }

    @Override
    public double applyDiscount(double total) {
        return Math.max(0, total - 30000);
    }
}

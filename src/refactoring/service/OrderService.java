package com.rikkei.refactoring.service;

import com.rikkei.refactoring.model.*;
import com.rikkei.refactoring.strategy.*;
import com.rikkei.refactoring.notification.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final List<VoucherStrategy> voucherStrategies;
    private final Map<String, PaymentStrategy> paymentStrategies;
    private final NotificationService notificationService;

    public OrderService(List<VoucherStrategy> voucherStrategies,
                        List<PaymentStrategy> paymentStrategies,
                        NotificationService notificationService) {
        this.voucherStrategies = voucherStrategies;
        this.paymentStrategies = paymentStrategies.stream()
                .collect(Collectors.toMap(PaymentStrategy::getMethodName, Function.identity()));
        this.notificationService = notificationService;
    }

    public Order checkout(Cart cart, User user, String paymentMethod, String voucherCode) {
        // 1. Kiểm tra trạng thái User
        if (user.getStatus() != 1) {
            throw new RuntimeException("User locked");
        }

        // 2. Tính tiền gốc của giỏ hàng
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // 3. Áp dụng mã giảm giá động thông qua Voucher Strategies
        if (voucherCode != null) {
            for (VoucherStrategy strategy : voucherStrategies) {
                if (strategy.isApplicable(voucherCode)) {
                    total = strategy.applyDiscount(total);
                    break;
                }
            }
        }

        // 4. Xử lý thanh toán động thông qua Payment Strategies Map
        PaymentStrategy paymentStrategy = paymentStrategies.get(paymentMethod);
        if (paymentStrategy == null) {
            throw new RuntimeException("Payment not supported: " + paymentMethod);
        }
        paymentStrategy.processPayment(total);

        // 5. Gửi thông báo thông qua dịch vụ thông báo độc lập
        String message = "Your order details. Total payment amount: " + total;
        notificationService.sendNotification(user, message);

        return new Order(user, total, "SUCCESS");
    }
}

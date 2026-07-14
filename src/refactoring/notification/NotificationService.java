package com.rikkei.refactoring.notification;
import com.rikkei.refactoring.model.User;

public interface NotificationService {
    void sendNotification(User user, String message);
}
// 

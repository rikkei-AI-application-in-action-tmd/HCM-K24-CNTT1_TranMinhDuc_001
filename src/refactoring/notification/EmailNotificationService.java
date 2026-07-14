package com.rikkei.refactoring.notification;
import com.rikkei.refactoring.model.User;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + " details: " + message);
    }
}

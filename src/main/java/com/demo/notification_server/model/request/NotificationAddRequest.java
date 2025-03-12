package com.demo.notification_server.model.request;

public record NotificationAddRequest(
        Long userId,
        String paymentLink,
        String email
) {
}

package com.demo.notification_server.model.request;

public record NotificationPostRequest(
        Long userId,
        String paymentLink,
        String email
) {
}

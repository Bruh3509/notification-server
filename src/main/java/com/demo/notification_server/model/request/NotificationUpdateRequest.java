package com.demo.notification_server.model.request;

public record NotificationUpdateRequest(
        Long userId,
        String paymentUrl
) {
}

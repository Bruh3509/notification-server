package com.demo.notification_server.model.request;

public record NotificationPostRequest(
        String paymentLink,
        String email
) {
}

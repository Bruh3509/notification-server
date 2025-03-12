package com.demo.notification_server.service;

public interface EmailService {
    void sendPaymentUrl(String to, String subject, String text);
}

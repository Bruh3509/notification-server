package com.demo.notification_server.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendPaymentUrl(String to, String subject, String text);

    void sendPaymentUrl(SimpleMailMessage[] mailMessages);

    SimpleMailMessage createSimpleMessage(String to, String subject, String text);
}

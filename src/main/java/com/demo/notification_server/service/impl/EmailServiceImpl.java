package com.demo.notification_server.service.impl;

import com.demo.notification_server.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailServiceImpl implements EmailService {
    JavaMailSender mailSender;

    @Override
    public void sendPaymentUrl(String to, String subject, String text) {
        var message = createSimpleMessage(to, subject, text);
        mailSender.send(message);
    }

    @Override
    public void sendPaymentUrl(SimpleMailMessage[] mailMessages) {
        mailSender.send(mailMessages);
    }

    @Override
    public SimpleMailMessage createSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@cars.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        return message;
    }
}

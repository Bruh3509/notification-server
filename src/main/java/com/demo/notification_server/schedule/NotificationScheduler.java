package com.demo.notification_server.schedule;

import com.demo.notification_server.service.EmailService;
import com.demo.notification_server.service.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationScheduler {
    static String SUBJECT = "Not Payed Rides";
    static String TEXT = "You have not payed ride, please follow the link bellow:%n%s";
    NotificationService notificationService;
    EmailService emailService;

    @Scheduled(cron = "0 0 15 * * ?") // fires every day at 15 pm. IDK how to test this
    public void sendEmailReminder() {
        var messages = notificationService.getAllUnpayed().stream()
                .filter(ride -> Duration.between(ride.getLastCheck(), Instant.now()).toDays() > 0)
                .map(ride -> emailService.createSimpleMessage(ride.getEmail(),
                        SUBJECT,
                        TEXT.formatted(ride.getPaymentLink()))
                )
                .toList()
                .toArray(new SimpleMailMessage[0]);

        emailService.sendPaymentUrl(messages);
    }
}

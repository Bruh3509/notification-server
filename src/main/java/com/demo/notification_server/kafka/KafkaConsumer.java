package com.demo.notification_server.kafka;

import com.demo.cars.kafka.model.MyKafkaMessage;
import com.demo.notification_server.mapper.NotificationMapper;
import com.demo.notification_server.service.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaConsumer {
    NotificationService notificationService;
    NotificationMapper notificationMapper;

    @KafkaListener(topics = "#{@environment.getProperty('spring.kafka.consumer.new-topic')}",
            groupId = "#{@environment.getProperty('spring.kafka.consumer.group-id')}")
    public void newPaymentConsumer(MyKafkaMessage newPayment) {
        log.info("New payment received:{}", newPayment.toString());
        notificationService.addNewDocument(
                notificationMapper.messageToAddRequest(newPayment)
        );
    }

    @KafkaListener(topics = "#{@environment.getProperty('spring.kafka.consumer.update-topic')}",
            groupId = "#{@environment.getProperty('spring.kafka.consumer.group-id')}")
    public void updatePaymentConsumer(MyKafkaMessage updatePayment) {
        log.info("Update payment received:{}", updatePayment.toString());
        notificationService.updateDocument(
                notificationMapper.messageToUpdateRequest(updatePayment)
        );
    }
}

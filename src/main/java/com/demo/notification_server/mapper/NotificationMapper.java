package com.demo.notification_server.mapper;

import com.demo.cars.kafka.model.MyKafkaMessage;
import com.demo.notification_server.document.Notification;
import com.demo.notification_server.dto.NotificationDto;
import com.demo.notification_server.model.request.NotificationAddRequest;
import com.demo.notification_server.model.request.NotificationUpdateRequest;
import com.demo.notification_server.util.enums.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring", imports = {Status.class, Instant.class})
public interface NotificationMapper {
    NotificationDto documentToDto(Notification notification);

    List<NotificationDto> documentToDto(List<Notification> notifications);

    @Mapping(target = "status", constant = "NOT_PAYED")
    @Mapping(target = "lastCheck", expression = "java(Instant.now())")
    Notification requestToEntity(NotificationAddRequest request);

    NotificationAddRequest messageToAddRequest(MyKafkaMessage message);

    NotificationUpdateRequest messageToUpdateRequest(MyKafkaMessage message);
}

package com.demo.notification_server.service;

import com.demo.notification_server.dto.NotificationDto;
import com.demo.notification_server.model.request.NotificationPostRequest;
import com.demo.notification_server.model.request.NotificationUpdateRequest;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> getAllUnpayed();

    NotificationDto updateDocument(NotificationUpdateRequest request);

    NotificationDto addNewDocument(NotificationPostRequest request);
}

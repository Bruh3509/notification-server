package com.demo.notification_server.service.impl;

import com.demo.notification_server.dto.NotificationDto;
import com.demo.notification_server.exception.DocumentNotFoundException;
import com.demo.notification_server.mapper.NotificationMapper;
import com.demo.notification_server.model.request.NotificationAddRequest;
import com.demo.notification_server.model.request.NotificationUpdateRequest;
import com.demo.notification_server.repository.NotificationRepository;
import com.demo.notification_server.service.NotificationService;
import com.demo.notification_server.util.enums.Status;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationServiceImpl implements NotificationService {
    NotificationRepository repository;
    NotificationMapper mapper;

    @Override
    public List<NotificationDto> getAllUnpayed() {
        return mapper.documentToDto(
                repository.findByStatus(Status.NOT_PAYED)
        );
    }

    @Override
    public NotificationDto updateDocument(NotificationUpdateRequest request) {
        var doc = repository.findById(request.userId())
                .orElseThrow(DocumentNotFoundException::new);
        doc.setStatus(Status.PAYED);
        return mapper.documentToDto(
                repository.save(doc)
        );
    }

    @Override
    public NotificationDto addNewDocument(NotificationAddRequest request) {
        return mapper.documentToDto(
                repository.save(
                        mapper.requestToEntity(request)
                )
        );
    }
}

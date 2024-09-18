package com.demo.notification_server.controller;

import com.demo.notification_server.dto.NotificationDto;
import com.demo.notification_server.model.request.NotificationAddRequest;
import com.demo.notification_server.model.request.NotificationUpdateRequest;
import com.demo.notification_server.model.response.TestResponse;
import com.demo.notification_server.service.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController {
    NotificationService notificationService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<TestResponse> testResponse() {
        return new ResponseEntity<>(
                new TestResponse("Hello from `notification` service"),
                HttpStatus.OK
        );
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<NotificationDto> addNewPayment(
            @RequestBody NotificationAddRequest request
    ) {
        return new ResponseEntity<>(
                notificationService.addNewDocument(request),
                HttpStatus.CREATED
        );
    }

    @PatchMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<NotificationDto> updatePaymentStatus(
            @RequestBody NotificationUpdateRequest request
    ) {
        return new ResponseEntity<>(
                notificationService.updateDocument(request),
                HttpStatus.OK
        );
    }
}

package com.demo.notification_server.controller;

import com.demo.notification_server.model.response.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @GetMapping(produces = "application/json")
    public ResponseEntity<TestResponse> testResponse() {
        return new ResponseEntity<>(new TestResponse("Success!"), HttpStatus.OK);
    }
}

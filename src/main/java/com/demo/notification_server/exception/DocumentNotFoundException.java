package com.demo.notification_server.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String message) {
        super(message);
    }
}

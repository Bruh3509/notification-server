package com.demo.notification_server.repository;

import com.demo.notification_server.document.Notification;
import com.demo.notification_server.util.enums.Status;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, Long> {
    List<Notification> findByStatus(Status status);
}

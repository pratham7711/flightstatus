package com.example.flightstatus.consumer;

import com.example.flightstatus.model.NotificationEvent;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

//    @KafkaListener(topics = "notification-events", groupId = "notification-group")
//public void consume(NotificationEvent event) {
//    // Logic to dispatch the notification to the notification service
//    System.out.println("Notification sent to passenger: " + event.getPassengerId() +
//            " for flight: " + event.getFlightId() +
//            " with status: " + event.getStatus() +
//            " and additional info: " + event.getAdditionalInfo());
//}
}
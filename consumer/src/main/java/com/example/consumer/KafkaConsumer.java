package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listener(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "my-topic-1", groupId = "my-group")
    public void riderListener(String message) {
        System.out.println("Received message: " + message);
    }
}

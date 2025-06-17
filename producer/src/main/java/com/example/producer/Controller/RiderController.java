package com.example.producer.Controller;

import com.example.producer.Model.Rider;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RiderController {
    private final KafkaTemplate<String, Rider> kafkaTemplate;

    public RiderController(KafkaTemplate<String, Rider> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/serializing")
    public String serializing() {
        Rider rider = new Rider("John", "Doe", 30);
        kafkaTemplate.send("my-topic-1", rider);
        return "Message sent to Kafka topic: " + rider.getFirstName();
    }
}

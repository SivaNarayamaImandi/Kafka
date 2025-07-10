package com.example.producer.Streams;

import com.example.producer.Model.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;
@Configuration
public class KafkaCloudStreams {
    @Bean
    public Supplier<Rider> sendRider() {
        return () -> {
            Rider rider = new Rider("John", "Doe", 30);
            System.out.println("Message sent to Kafka topic: " + rider.getFirstName());
            return rider;
        };
    }
}

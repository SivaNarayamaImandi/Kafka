package com.example.producer.Streams;

import com.example.producer.Model.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Supplier;
@Configuration
public class KafkaCloudStreams {
    @Bean
    public Supplier<Rider> sendRider() {
        Random random = new Random();
        return () -> {
            Rider rider = new Rider("RiderId-" + random.nextInt(20), "Doe", 30);
            System.out.println("Message sent to Kafka topic: " + rider.getFirstName());
            return rider;
        };
    }
}

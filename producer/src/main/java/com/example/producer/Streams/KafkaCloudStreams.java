package com.example.producer.Streams;

import com.example.producer.Model.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

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
    @Bean
    public Supplier<Message<String>> sendAge() {
        Random random = new Random();
        return () -> {
            Rider rider = new Rider("John", "Doe", random.nextInt(35));
            String status = rider.getAge() >= 18 ? "Major" : "Minor";
            System.out.println("Message sent to Kafka topic: " + status);
            return MessageBuilder
                    .withPayload(rider.getFirstName() + " is " + status)
                    .setHeader(KafkaHeaders.KEY, rider.getFirstName().getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }
}

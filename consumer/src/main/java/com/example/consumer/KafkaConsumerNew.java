package com.example.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerNew {
    @Bean
    public Consumer<Rider> riderName(){
        return rider -> {
            System.out.println("Received: " + rider.getFirstName() + ", " + rider.getLastName() + ", " + rider.getAge());
        };
    }
}

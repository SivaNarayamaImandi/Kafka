package com.example.producer.Controller;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class KafkaProducerController {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/sent")
//    public String message(@RequestParam String msg) {
//        kafkaTemplate.send("my-topic", msg);
//        return "Message sent to Kafka topic: " + msg;
//    }
//}

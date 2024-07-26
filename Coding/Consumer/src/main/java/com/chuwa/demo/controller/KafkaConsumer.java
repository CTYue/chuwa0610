package com.chuwa.demo.controller;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
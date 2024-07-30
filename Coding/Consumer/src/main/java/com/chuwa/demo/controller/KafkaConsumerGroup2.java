package com.chuwa.demo.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerGroup2 {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group-2")
    public void consume(String message) {
        System.out.println("Group 2 Consumed message: " + message);
    }
}
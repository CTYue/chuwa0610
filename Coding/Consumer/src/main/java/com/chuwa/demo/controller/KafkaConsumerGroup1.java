package com.chuwa.demo.controller;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerGroup1 {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group-1")
    public void consume(String message) {
        System.out.println("Group 1 Consumed message: " + message);
    }
}
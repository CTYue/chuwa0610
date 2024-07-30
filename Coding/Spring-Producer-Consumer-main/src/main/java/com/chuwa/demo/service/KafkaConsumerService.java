package com.chuwa.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Create 07/2024
 * @Author xiao
 * @Description
 */

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "chuwa-consumers")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

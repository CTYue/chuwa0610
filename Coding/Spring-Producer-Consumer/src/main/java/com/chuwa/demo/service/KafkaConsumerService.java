package com.chuwa.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final MessageStorageService messageStorageService;

    public KafkaConsumerService(MessageStorageService messageStorageService) {
        this.messageStorageService = messageStorageService;
    }

    @KafkaListener(topics = "chuwa-yyds", groupId = "group1")
    public void consumeGroup1(String message) {
        messageStorageService.storeMessage("group1", "chuwa-yyds", message);
    }

    @KafkaListener(topics = "chuwa-yyds", groupId = "group2")
    public void consumeGroup2(String message) {
        messageStorageService.storeMessage("group2", "chuwa-yyds", message);
    }

}

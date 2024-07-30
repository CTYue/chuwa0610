package com.chuwa.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class KafkaMessageService {

    private final ConcurrentMap<String, List<String>> messagesByConsumerGroup = new ConcurrentHashMap<>();

    public void saveMessage(String consumerGroup, String message) {
        messagesByConsumerGroup.computeIfAbsent(consumerGroup, k -> new ArrayList<>()).add(message);
    }

    public List<String> getMessages(String consumerGroup) {
        return messagesByConsumerGroup.getOrDefault(consumerGroup, new ArrayList<>());
    }
}

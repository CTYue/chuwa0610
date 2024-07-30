package com.chuwa.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KafkaConsumerService {

    private final ConcurrentHashMap<String, List<String>> messageStore = new ConcurrentHashMap<>();

    @KafkaListener(topics = "${topic.name}", groupId = "group-1")
    public void consumeFromGroup1(String message) {
        messageStore.computeIfAbsent("group-1", k -> new ArrayList<>()).add(message);
        System.out.println("Group 1 Consumed message: " + message);
    }

    @KafkaListener(topics = "${topic.name}", groupId = "group-2")
    public void consumeFromGroup2(String message) {
        messageStore.computeIfAbsent("group-2", k -> new ArrayList<>()).add(message);
        System.out.println("Group 2 Consumed message: " + message);
    }

    public List<String> getMessages(String group, int page, int size) {
        List<String> messages = messageStore.getOrDefault(group, new ArrayList<>());
        int start = page * size;
        int end = Math.min(start + size, messages.size());
        return messages.subList(start, end);
    }
}
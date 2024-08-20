package com.chuwa.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class KafkaConsumerService {

    private final ConcurrentMap<String, List<String>> messages = new ConcurrentHashMap<>();

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group1", containerFactory = "kafkaListenerContainerFactory1")
    public void listen(String message) {
        System.out.println("Consumed Message: " + message);
        storeMessage("group1", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group2", containerFactory = "kafkaListenerContainerFactory2")
    public void listenGroup2(String message) {
        System.out.println("Received Message in group2: " + message);
        storeMessage("group2", message);
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group3", containerFactory = "kafkaListenerContainerFactory3")
    public void listenGroup3(String message) {
        System.out.println("Received Message in group3: " + message);
        storeMessage("group3", message);
    }

    private void storeMessage(String groupId, String message) {
        messages.computeIfAbsent(groupId, k -> new ArrayList<>()).add(message);
    }

    public List<String> getMessages(String groupId, int page, int size) {
        List<String> groupMessages = messages.getOrDefault(groupId, new ArrayList<>());
        int start = Math.min(page * size, groupMessages.size());
        int end = Math.min((page + 1) * size, groupMessages.size());
        return groupMessages.subList(start, end);
    }
}

package com.chuwa.demo.service;

import com.chuwa.demo.model.ConsumedMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MessageStorageService {
    private final ConcurrentHashMap<String, List<ConsumedMessage>> messages = new ConcurrentHashMap<>();

    public void saveMessage(String groupId, String topic, ConsumedMessage message) {
        String key = groupId + ":" + topic;
        messages.computeIfAbsent(key, k -> new CopyOnWriteArrayList<>()).add(message);
    }

    public List<ConsumedMessage> getMessages(String groupId, String topic) {
        String key = groupId + ":" + topic;
        return messages.getOrDefault(key, new CopyOnWriteArrayList<>());
    }
}

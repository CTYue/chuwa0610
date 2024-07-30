package com.chuwa.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MessageStorageService {
    private final ConcurrentMap<String, List<String>> messageStore = new ConcurrentHashMap<>();

    public void storeMessage(String groupId, String topic, String message) {
        String key = groupId + ":" + topic;
        messageStore.computeIfAbsent(key, k -> new ArrayList<>()).add(message);
    }

    public List<String> getMessages(String groupId, String topic, int page, int size) {
        String key = groupId + ":" + topic;
        List<String> messages = messageStore.getOrDefault(key, new ArrayList<>());
        int start = Math.min(page * size, messages.size());
        int end = Math.min((page + 1) * size, messages.size());
        return messages.subList(start, end);
    }

    public int getMessageCount(String groupId, String topic) {
        String key = groupId + ":" + topic;
        return messageStore.getOrDefault(key, new ArrayList<>()).size();
    }


}

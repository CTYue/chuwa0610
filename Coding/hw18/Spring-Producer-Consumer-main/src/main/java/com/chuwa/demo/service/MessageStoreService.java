package com.chuwa.demo.service;

import com.chuwa.demo.Entities.ConsumedMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MessageStoreService {

    private final ConcurrentMap<String, List<ConsumedMessage>> messageStore = new ConcurrentHashMap<>();

    public void addMessage(String consumerGroup, String topic, ConsumedMessage message) {
        String key = consumerGroup + "-" + topic;
        messageStore.computeIfAbsent(key, k -> new ArrayList<>()).add(message);
    }

    public List<ConsumedMessage> getMessages(String consumerGroup, String topic) {
        String key = consumerGroup + "-" + topic;
        List<ConsumedMessage> res = messageStore.getOrDefault(key, new ArrayList<>());
        return res;
    }
}
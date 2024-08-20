package com.chuwa.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String message) {
        kafkaTemplate.send(topicName, key, message);
    }
    public void sendMessage(String key, String message, String topicName) {
        kafkaTemplate.send(topicName, key, message);
    }

}

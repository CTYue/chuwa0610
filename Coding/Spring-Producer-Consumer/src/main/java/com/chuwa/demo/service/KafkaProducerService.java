package com.chuwa.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public void sendMessage(String key, String message) {
//        kafkaTemplate.send(topicName, key, message);
//    }

    public void sendMessage(String message) {
        String key = generateRoundRobinKey();
        kafkaTemplate.send(topicName, key, message);
    }

//    private String generatePartitionKey(String message) {
//        // Example: Hashing the message and modulo the number of partitions
//        int numberOfPartitions = 3; // This should be dynamic or configured if possible
//        return String.valueOf(message.hashCode() % numberOfPartitions);
//    }

    private static final int NUMBER_OF_PARTITIONS = 3;  // Adjust based on your topic's partition count
    private static int roundRobinCounter = 0;

    private synchronized String generateRoundRobinKey() {
        int key = roundRobinCounter % NUMBER_OF_PARTITIONS;
        roundRobinCounter = (roundRobinCounter + 1) % NUMBER_OF_PARTITIONS;
        return String.valueOf(key);
    }

}

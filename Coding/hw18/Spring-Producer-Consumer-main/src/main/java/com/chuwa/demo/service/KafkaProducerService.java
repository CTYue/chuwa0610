package com.chuwa.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String message) {

        int partitionKey = getPartitionKey(key);
        Message<String> kafkaMessage = MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC,topicName).
                setHeader(KafkaHeaders.PARTITION, partitionKey).build();
        kafkaTemplate.send(kafkaMessage);
    }

    private int getPartitionKey(String key) {
        int partitions = 3; // adjustable partitions num
        return Math.abs(key.hashCode() % partitions);
    }

}

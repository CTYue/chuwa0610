package com.chuwa.demo.service;

import com.chuwa.demo.model.ConsumedMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final MessageStorageService messageStorageService;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Autowired
    public KafkaConsumerService(MessageStorageService messageStorageService) {
        this.messageStorageService = messageStorageService;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "groupA", concurrency = "2")
    public void listenGroupA(ConsumerRecord<String, String> record) {
        ConsumedMessage consumedMessage = new ConsumedMessage();
        consumedMessage.setMessage(record.value());
        consumedMessage.setTopic(topicName);
        consumedMessage.setGroupId("groupA");
        consumedMessage.setPartition(record.partition());
        consumedMessage.setOffset(record.offset());
        consumedMessage.setConsumedAt(LocalDateTime.now());

        messageStorageService.saveMessage("groupA", topicName, consumedMessage);
        logger.info("Stored message in-memory from Kafka");
        System.out.printf("Group A - Consumer %s, Partition: %d, Offset: %d, Key: %s, Message: %s%n",
                Thread.currentThread().getName(), record.partition(), record.offset(), record.key(), record.value());
    }

    // Consumer Group B with 3 consumers
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "groupB", concurrency = "3")
    public void listenGroupB(ConsumerRecord<String, String> record) {
        ConsumedMessage consumedMessage = new ConsumedMessage();
        consumedMessage.setMessage(record.value());
        consumedMessage.setTopic(topicName);
        consumedMessage.setGroupId("groupB");
        consumedMessage.setPartition(record.partition());
        consumedMessage.setOffset(record.offset());
        consumedMessage.setConsumedAt(LocalDateTime.now());

        messageStorageService.saveMessage("groupB", topicName, consumedMessage);
        logger.info("Stored message in-memory from Kafka");
        System.out.printf("Group B - Consumer %s, Partition: %d, Offset: %d, Key: %s, Message: %s%n",
                Thread.currentThread().getName(), record.partition(), record.offset(), record.key(), record.value());
    }
}
package com.chuwa.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @KafkaListener(topics = "howard-yyds", groupId = "group-1")
    public void consumeGroup1(ConsumerRecord<String, String> record) {
        String message = String.format("Consumer Group 1 - Consumed message: %s from partition: %d", record.value(), record.partition());
        kafkaMessageService.saveMessage("group-1", message);
        System.out.println(message);
    }

    @KafkaListener(topics = "howard-yyds", groupId = "group-2")
    public void consumeGroup2(ConsumerRecord<String, String> record) {
        String message = String.format("Consumer Group 2 - Consumed message: %s from partition: %d", record.value(), record.partition());
        kafkaMessageService.saveMessage("group-2", message);
        System.out.println(message);
    }

    @KafkaListener(topics = "howard-yyds", groupId = "group-3")
    public void consumeGroup3(ConsumerRecord<String, String> record) {
        String message = String.format("Consumer Group 3 - Consumed message: %s from partition: %d", record.value(), record.partition());
        kafkaMessageService.saveMessage("group-3", message);
        System.out.println(message);
    }
}

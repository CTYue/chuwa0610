package com.chuwa.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerGroup {
    // Consumer Group A with 2 consumers
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "groupA", concurrency = "2")
    public void listenGroupA(ConsumerRecord<String, String> record) {
        System.out.printf("Group A - Consumer %s, Partition: %d, Offset: %d, Key: %s, Message: %s%n",
                Thread.currentThread().getName(), record.partition(), record.offset(), record.key(), record.value());
    }

    // Consumer Group B with 3 consumers
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "groupB", concurrency = "3")
    public void listenGroupB(ConsumerRecord<String, String> record) {
        System.out.printf("Group B - Consumer %s, Partition: %d, Offset: %d, Key: %s, Message: %s%n",
                Thread.currentThread().getName(), record.partition(), record.offset(), record.key(), record.value());
    }
}

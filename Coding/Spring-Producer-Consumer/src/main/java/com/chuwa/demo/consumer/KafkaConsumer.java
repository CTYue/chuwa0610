package com.chuwa.demo.consumer;

import com.chuwa.demo.service.KafkaConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "myGroup")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.printf("Consumer ID: %s, Partition: %d, Offset: %d, Key: %s, Message: %s%n",
                Thread.currentThread().getName(), record.partition(), record.offset(), record.key(), record.value());
    }
}

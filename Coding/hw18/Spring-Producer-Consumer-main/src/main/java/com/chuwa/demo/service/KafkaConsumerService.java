package com.chuwa.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Service
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "consumer_group")
    public void consume1(String message) {
        logger.info(String.format("Consumer Group 1 - Message consumed -> %s", message));
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        String consumerInstanceId = "Consumer-" + Thread.currentThread().getId(); // Or any unique identifier for the consumer
        logger.info("Received message: key={}, value={} from partition={}, offset={} by {}",
                record.key(), record.value(), record.partition(), record.offset(), consumerInstanceId);
    }
}

package com.chuwa.demo.service;

import com.chuwa.demo.Entities.ConsumedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Service
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);


    @Autowired
    private MessageStoreService messageStoreService;
/*
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "consumer_group")
    public void consume1(String message) {
        logger.info(String.format("Consumer Group 1 - Message consumed -> %s", message));
    }
*/

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "consumer_group")
    public void listen(ConsumerRecord<String, String> record) {
        String consumerInstanceId = "Consumer-" + Thread.currentThread().getId(); // Or any unique identifier for the consumer
        logger.info("Consumer Group 1 - Received message: key={}, value={} from partition={}, offset={} by {}",
                record.key(), record.value(), record.partition(), record.offset(), consumerInstanceId);
        ConsumedMessage consumedMessage = new ConsumedMessage("Group1",record.value(), record.partition(), record.offset());
        messageStoreService.addMessage("group-1", "chuwa-yyds", consumedMessage);


    }
}
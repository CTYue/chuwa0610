package com.chuwa.demo.service;

import com.chuwa.demo.entity.ConsumedMessage;
import com.chuwa.demo.repository.MessageRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${kafka.consumer.group-id}")
    private String groupId;

    @Value("${kafka.consumer.group-id2}")
    private String groupId2;

    @Autowired
    MessageRepository messageRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group-id}")
    public void listenGroupFoo(ConsumerRecord<String, String> record) {
        logger.info("Received Message: {}:'{}' from partition: {} at offset: {}", groupId, record.value(), record.partition(), record.offset());
        ConsumedMessage consumedMessage = new ConsumedMessage(record.topic(), groupId, record.partition(), record.offset(), record.key(), record.value());
        messageRepository.save(consumedMessage);
//        logger.info("Consumed message: {}, which is written in to database", consumedMessage);
    }

    @KafkaListener(topics = "${kafka.topic.name2}", groupId = "${kafka.consumer.group-id2}")
    public void listenGroupFoo2(ConsumerRecord<String, String> record) {
        logger.info("Received Message: {}:'{}' from partition: {} at offset: {}", groupId2, record.value(), record.partition(), record.offset());
        ConsumedMessage consumedMessage = new ConsumedMessage(record.topic(), groupId2, record.partition(), record.offset(), record.key(), record.value());
        messageRepository.save(consumedMessage);
    }
}

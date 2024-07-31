package com.chuwa.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumer2 {
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "group_topic_test2")
    public void topicListener1(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println("group1,0:" + value + ", offset:" + record.offset() );
    }
}
package com.example.spring_kafka_demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    //listen the message that the topic is topic_test,  the message will be consumed by opicListener1 in  group_topic_test
    @KafkaListener(topics = "topic_test", groupId = "group_topic_test")
    public void topicListener1(ConsumerRecord<String, String> record, Acknowledgment item) {
        String value = record.value();
        System.out.println("Received: " + value);// message context
        System.out.println("Record: " + record);// message basic info(key, offset, partition)
        // submit manually
        item.acknowledge();//submit the offset, make sure the massage is consumed.
    }

    @KafkaListener(topics = "topic_test2", groupId = "group_topic_test2")
    public void topicListener2(ConsumerRecord<String, String> record, Acknowledgment item) {
        String value = record.value();
        System.out.println("Received: " + value);
        System.out.println("Record: " + record);
        item.acknowledge();
    }
}
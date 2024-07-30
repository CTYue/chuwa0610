package com.chuwa.demo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {


    @KafkaListener(id = "consumer", topics = "#{@topicName}", groupId = "group1")
    public void listen(ConsumerRecord<?, ?> record) {

        System.out.println(record);
    }


}
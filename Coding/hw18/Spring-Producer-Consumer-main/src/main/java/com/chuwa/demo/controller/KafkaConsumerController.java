package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaConsumerService;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaConsumerController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;
}

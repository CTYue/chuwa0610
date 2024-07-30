package com.chuwa.demo.controller;

import com.chuwa.demo.Entities.ConsumedMessage;
import com.chuwa.demo.service.KafkaConsumerService;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaConsumerController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;


}

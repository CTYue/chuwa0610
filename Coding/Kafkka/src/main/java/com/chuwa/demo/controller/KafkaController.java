package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaConsumerService;
import com.chuwa.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;



    @PostMapping("/publish")
    public String publishMessage(@RequestParam("key") String key, @RequestParam("topic") String topic, @RequestParam("message") String message) {
        kafkaProducerService.sendMessage(key, message, topic);
        return "Message published successfully";
    }

    @GetMapping("/message")
    public List<String> getMessage(@RequestParam("group") String group, @RequestParam("topic") String topic) {

        return kafkaConsumerService.getMessage(group, topic);
    }
}

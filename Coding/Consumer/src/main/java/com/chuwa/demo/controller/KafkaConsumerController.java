package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaConsumerController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @GetMapping("/messages")
    public List<String> getMessages(
            @RequestParam String group,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return kafkaConsumerService.getMessages(group, page, size);
    }
}
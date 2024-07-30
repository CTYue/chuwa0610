package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaMessageService;
import com.chuwa.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message, @RequestParam("partition") int partition) {
        kafkaProducerService.sendMessage(message, partition);
        return "Message published successfully";
    }

    @GetMapping("/messages")
    public List<String> getMessages(@RequestParam String groupId) {
        return kafkaMessageService.getMessages(groupId);
    }
}

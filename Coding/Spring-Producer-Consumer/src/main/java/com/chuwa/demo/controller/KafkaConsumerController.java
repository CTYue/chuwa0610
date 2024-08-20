package com.chuwa.demo.controller;

import com.chuwa.demo.model.ConsumedMessage;
import com.chuwa.demo.service.KafkaProducerService;
import com.chuwa.demo.service.MessageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/messages")
public class KafkaConsumerController {

    @Autowired
    private MessageStorageService messageStorageService;

    @GetMapping
    public List<ConsumedMessage> getMessages(@RequestParam String groupId, @RequestParam String topic) {
        return messageStorageService.getMessages(groupId, topic);
    }
}

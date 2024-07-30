package com.chuwa.demo.controller;

import com.chuwa.demo.entity.ConsumedMessage;
import com.chuwa.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class UserController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public Page<ConsumedMessage> getMessages(@RequestParam String consumerGroup, @RequestParam String topic, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageRepository.findByConsumerGroupAndTopic(consumerGroup, topic, pageable);
    }
}


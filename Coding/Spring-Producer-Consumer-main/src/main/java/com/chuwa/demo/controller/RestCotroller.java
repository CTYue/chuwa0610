package com.chuwa.demo.controller;

import com.chuwa.demo.Entities.ConsumedMessage;
import com.chuwa.demo.service.KafkaConsumerService;
import com.chuwa.demo.service.MessageStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class RestCotroller {

    @Autowired
    private MessageStoreService messageStoreService;

    @GetMapping("/messages")
    public List<ConsumedMessage> getMessages(@RequestParam String consumerGroup,
                                             @RequestParam String topic,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        List<ConsumedMessage> allMessages = messageStoreService.getMessages(consumerGroup, topic);
        int fromIndex = Math.min(page * size, allMessages.size());
        int toIndex = Math.min((page + 1) * size, allMessages.size());
        return allMessages.subList(fromIndex, toIndex);
    }
}
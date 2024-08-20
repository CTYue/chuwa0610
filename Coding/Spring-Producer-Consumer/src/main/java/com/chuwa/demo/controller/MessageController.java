package com.chuwa.demo.controller;

import com.chuwa.demo.service.MessageStorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final MessageStorageService messageStorageService;

    public MessageController(MessageStorageService messageStorageService) {
        this.messageStorageService = messageStorageService;
    }

    @GetMapping("/messages")
    public List<String> getMessages(
            @RequestParam("groupId") String groupId,
            @RequestParam("topic") String topic,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return messageStorageService.getMessages(groupId, topic, page, size);
    }
}
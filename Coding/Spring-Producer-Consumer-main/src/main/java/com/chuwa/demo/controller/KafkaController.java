package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaConsumerService;
import com.chuwa.demo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("key") String key, @RequestParam("message") String message) {
        kafkaProducerService.sendMessage(key, message);
        return "Message published successfully";
    }
    @PostMapping("/publish/{topic}")
    public String publishMessage(@PathVariable("topic") String topic, @RequestParam("key") String key, @RequestParam("message") String message) {
        kafkaProducerService.sendMessage(key, message, topic);
        return "Message published successfully";
    }

    @GetMapping("/getTopics")
    public ResponseEntity<Set<String>> getTopics() {
        return ResponseEntity.ok(kafkaConsumerService.getTopics());
    }

}

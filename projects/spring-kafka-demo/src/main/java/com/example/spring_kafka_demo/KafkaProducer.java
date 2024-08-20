package com.example.spring_kafka_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @RequestMapping("/send")
    public String send() {// sent request in postman:   http://localhost:8084/kafka/send
        //send message: inculde topic key  data
        kafkaTemplate.send("topic_test", "key", "message 7");
        return "Message sent to topic_test";
    }

}

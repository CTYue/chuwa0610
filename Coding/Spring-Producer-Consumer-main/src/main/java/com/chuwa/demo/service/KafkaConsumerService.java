package com.chuwa.demo.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ConsumerFactory<String, String> consumerFactory;

    public Set<String> getTopics() {
        Consumer<String, String> consumer = consumerFactory.createConsumer();
        Set<String> body = consumer.listTopics().keySet();
        consumer.close();
        return body;
    }
}

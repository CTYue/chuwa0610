package com.chuwa.demo.service;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.*;



@Service
public class KafkaConsumerService {
    Map<String, List<KafkaConsumer<String, String>>> consumerMap = new HashMap<>();
    String[] topics = new String[] {"topic0", "topic1"};

    @PostConstruct
    public void init() {
        createListener("group0");
        createListener("group0");
        createListener("group0");
        createListener("group1");
        createListener("group1");
    }

    private void createListener(String groupId) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        KafkaConsumer<String, String>  consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topics));

        if (!consumerMap.containsKey(groupId)) {
            consumerMap.put(groupId, new ArrayList<KafkaConsumer<String, String>>());
        }
        consumerMap.get(groupId).add(consumer);
        consumer.poll(Duration.ofMillis(100));
    }

    public List<String> getMessage(String groupId, String topic) {
        List<String> retList = new ArrayList<>();
        for (KafkaConsumer<String, String> consumer : consumerMap.get(groupId)) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            for (ConsumerRecord<String, String> record : records) {
                retList.add(record.value());
            }
        }
        return retList;
    }

}

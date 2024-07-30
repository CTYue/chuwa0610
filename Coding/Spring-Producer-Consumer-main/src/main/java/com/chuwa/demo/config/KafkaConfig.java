package com.chuwa.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: KafkaConfig
 * date: 7/30/24 12:37 AM
 * author: jinhao_pang
 * version: 1.0
 */
@Configuration
public class KafkaConfig {
    @Value("${kafka.topic.name}")
    private String topicName;

    @Bean
    public String topicName() {
        return topicName;
    }
}

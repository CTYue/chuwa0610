package com.chuwa.consumerdemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}

	@KafkaListener(topics = "chuwa-yyds", groupId = "my-consumer-group", concurrency = "6")
	public void listen1(ConsumerRecord<String, String> record) {
		System.out.printf("Received Message in group '%s' by Thread '%s': topic=%s, partition=%d, offset=%d, key=%s, value=%s%n",
				"my-consumer-group", Thread.currentThread().getName(),
				record.topic(), record.partition(), record.offset(), record.key(), record.value());
	}

}

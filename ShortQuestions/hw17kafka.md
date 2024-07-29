## 3. 
![Alt text](/ShortQuestions/images/kafka_consumer_3.png)
Increase number of consumers to five
![Alt text](/ShortQuestions/images/kafka_consumer_5.png)
- Balanced Partition Assignment:
Kafka ensures that each partition is consumed by only one consumer at a time within a consumer group. With 3 partitions and 5 consumers, Kafka will assign each partition to a different consumer, resulting in 3 active consumers and 2 idle consumers.

- Dynamic Rebalancing:
If one of the active consumers stops, Kafka will automatically rebalance the partitions among the remaining consumers. This ensures that all partitions are always being consumed.

- Idle Consumers:
The number of active consumers is limited by the number of partitions. If you have more consumers than partitions, the extra consumers will remain idle until more partitions become available.

## 4. 
![Alt text](/ShortQuestions/images/kafka_consumer_two_groups.png)
At Most Once:
Set enable.auto.commit to true and auto.commit.interval.ms to a low value.

``` 
props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
```

This configuration ensures that offsets are committed frequently, but there is a risk of message loss in case of a failure.

At Least Once:
Set enable.auto.commit to false and manually commit offsets after processing messages.

KafkaConsumerService.java:

``` 
@KafkaListener(topics = "chuwa-yyds", groupId = "consumer-group")
public void consume(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
System.out.printf("Consumed message: %s from partition: %d%n", record.value(), record.partition());
acknowledgment.acknowledge(); // Manually commit offset
}
```

Exactly Once:
Use Kafka transactions for exactly-once semantics. Configure both the producer and consumer to use transactions.

Producer Configuration:

``` 
props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "my-transactional-id");
```

Consumer Configuration:

``` 
props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
```
Transactional Producer Code:

``` 
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

public void sendMessage(String key, String message) {
kafkaTemplate.executeInTransaction(kafkaOperations -> {
kafkaOperations.send(TOPIC, key, message);
return true;
});
}
```
5. 
Step 1: Create REST Controller

KafkaMessageController.java:
``` 
package com.chuwa.demo.controller;

import com.chuwa.demo.service.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @GetMapping("/messages")
    public Page<String> getMessages(
            @RequestParam String consumerGroup,
            @RequestParam String topic,
            @RequestParam int page,
            @RequestParam int size) {
        return kafkaMessageService.getMessages(consumerGroup, topic, PageRequest.of(page, size));
    }
}
```

Step 2: Create REST Controller
KafkaMessageService.java:
``` 
package com.chuwa.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class KafkaMessageService {

    private final ConcurrentMap<String, List<String>> messagesByConsumerGroup = new ConcurrentHashMap<>();

    public void saveMessage(String consumerGroup, String message) {
        messagesByConsumerGroup.computeIfAbsent(consumerGroup, k -> new ArrayList<>()).add(message);
    }

    public Page<String> getMessages(String consumerGroup, String topic, PageRequest pageRequest) {
        List<String> messages = messagesByConsumerGroup.getOrDefault(consumerGroup, new ArrayList<>());
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), messages.size());
        List<String> pagedMessages = messages.subList(start, end);
        return new PageImpl<>(pagedMessages, pageRequest, messages.size());
    }
}
```
Step 3: Modify Consumer Service to Save Messages
KafkaConsumerService1.java:
``` 
package com.chuwa.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService1 {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @KafkaListener(topics = "chuwa-yyds", groupId = "consumer-group-1", containerFactory = "kafkaListenerContainerFactory1")
    public void consume(ConsumerRecord<String, String> record) {
        String message = String.format("Consumed message: %s from partition: %d", record.value(), record.partition());
        kafkaMessageService.saveMessage("consumer-group-1", message);
        System.out.println(message);
    }
}
```
KafkaConsumerService2.java:
``` 
package com.chuwa.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService2 {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @KafkaListener(topics = "chuwa-yyds", groupId = "consumer-group-2", containerFactory = "kafkaListenerContainerFactory2")
    public void consume(ConsumerRecord<String, String> record) {
        String message = String.format("Consumed message: %s from partition: %d", record.value(), record.partition());
        kafkaMessageService.saveMessage("consumer-group-2", message);
        System.out.println(message);
    }
}
```

- REST Controller:

The KafkaMessageController handles HTTP GET requests to retrieve messages.
It supports pagination by taking page and size parameters.
- Service Logic:

The KafkaMessageService manages the storage and retrieval of messages.
It uses a ConcurrentHashMap to store messages by consumer group.
The getMessages method retrieves messages and returns them in a paginated format.
- Consumer Services:

Modified to save consumed messages to KafkaMessageService for later retrieval through the API.
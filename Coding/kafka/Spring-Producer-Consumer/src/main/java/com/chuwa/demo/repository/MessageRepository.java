package com.chuwa.demo.repository;

import com.chuwa.demo.entity.ConsumedMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<ConsumedMessage, Long> {
    Page<ConsumedMessage> findByConsumerGroupAndTopic(String consumerGroup, String topic, Pageable pageable);
}


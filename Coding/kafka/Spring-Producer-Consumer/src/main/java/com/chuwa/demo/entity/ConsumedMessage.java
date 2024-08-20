package com.chuwa.demo.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class ConsumedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String consumerGroup;

    @Column(name = "`partition`")
    private int partition;

    private long offset;

    @Column(name = "`key`")  // 使用反引号转义
    private String key;

    private String value;
    private Timestamp timestamp;

    public ConsumedMessage() {
    }

    public ConsumedMessage(String topic, String consumerGroup, int partition, long offset, String key, String value) {
        this.topic = topic;
        this.consumerGroup = consumerGroup;
        this.partition = partition;
        this.offset = offset;
        this.key = key;
        this.value = value;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
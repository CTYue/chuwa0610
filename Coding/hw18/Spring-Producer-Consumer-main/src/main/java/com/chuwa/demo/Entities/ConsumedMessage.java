package com.chuwa.demo.Entities;


public class ConsumedMessage {
    private String group;
    private String message;
    private int partition;
    private long offset;

    public ConsumedMessage(String group1, String value, int partition, long offset) {
        group = group1;
        message = value;
        this.partition = partition;
        this.offset = offset;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}

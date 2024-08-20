package com.chuwa.demo.config;


import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomizePartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        List<PartitionInfo> partitionInfoList = cluster.availablePartitionsForTopic(topic);
        int partitionCount = partitionInfoList.size();
        int auditPartition = Math.abs(key.hashCode()) % partitionCount;

        return auditPartition;
    }

    @Override
    public void close() {
        System.out.println("colse ...");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("init ...");
    }
}

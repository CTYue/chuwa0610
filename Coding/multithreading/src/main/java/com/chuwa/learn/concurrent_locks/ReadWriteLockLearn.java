package com.chuwa.learn.concurrent_locks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockLearn {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        List<Thread> tWrites = new ArrayList<>();

        // 创建和启动读线程
        for (int i = 0; i < 5; i++) {
            Thread tRead = new Thread(() -> {
                int[] nums = counter.get();
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            });
            tRead.start();
            threads.add(tRead);
        }

        // 创建和启动写线程
        for (int j = 0; j < 2; j++) {
            Thread tWrite = new Thread(() -> {
                for (int I = 0; I < 5; I++) {
                    counter.inc(I); // 使用正确的变量 I
                }
            });
            tWrite.start();
            tWrites.add(tWrite);
        }

        // 等待写线程完成
        for (Thread tWrite : tWrites) {
            tWrite.join();
        }

        // 等待一小段时间，然后打印最终结果
        Thread.sleep(1000);
        System.out.println("Final values in the counter:");
        int[] finalNums = counter.get();
        for (int num : finalNums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 中断读线程
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
class Counter{
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}

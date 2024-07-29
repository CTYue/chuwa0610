package com.chuwa.learn.concurrent_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CounterSynchronized{
    private int count;
    public void add(int n){
        synchronized (this){
            count += n;
        }
    }
    public int getCount(){
        return count;
    }
}
class CounterReentrant{
    private final Lock lock = new ReentrantLock();
    private int count;
    public void add(int n){
        // 可重入锁 防止自锁
        lock.lock();
        try{
            count += n;
        }finally {
           lock.unlock();
        }
    }
    public int getCount(){
        return count;
    }
}
public class ReentrantLockLearn {
    public static void main(String[] args) {
        CounterReentrant counterReentrant = new CounterReentrant();
        Thread t1 = new Thread(() -> {
            int n = 20;
            while(n-- > 0){
                counterReentrant.add(2);
                System.out.println("t1 add 2: " + counterReentrant.getCount());
            }
        });

        Thread t2 = new Thread(() -> {
            int n = 20;
            while(n-- > 0){
                counterReentrant.add(100);
                System.out.println("t2 add 100: " + counterReentrant.getCount());
            }
        });
        t1.start();
        t2.start();
    }
}

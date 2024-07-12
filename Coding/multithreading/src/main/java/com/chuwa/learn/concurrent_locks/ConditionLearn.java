package com.chuwa.learn.concurrent_locks;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionLearn {
    public static void main(String[] args) {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Thread consumer = new Thread(()->{
                while(true){
                    try{
                        String task = q.getTask();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

            System.out.println("Consumer Thread " + i + "start ...");
            consumer.start();
            ts.add(consumer);
        }
    }

}

class TaskQueue extends Thread{
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<String> queue = new LinkedList<>();

    public void addTask(String s){
        lock.lock();
        try{
            queue.add(s);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException{
        lock.lock();
        try{
            while(queue.isEmpty()){
                condition.await();
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }
}


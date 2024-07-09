package com.chuwa.learn.waitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();//t0
        new Thread(runnable).start();//t1
    }

    static class PrintRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        @Override
        public void run() {

            lock.lock();
            try   {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signalAll();
                    try {
                        condition.await(); // 解锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
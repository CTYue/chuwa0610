package com.chuwa.learn.creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class MyThreadPool implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        // 使用 Executors 工厂方法创建固定大小的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 提交任务给线程池执行
        service.execute(new MyThreadPool());

        // 关闭线程池，不再接受新的任务，已提交的任务继续执行
        service.shutdown();
    }
}
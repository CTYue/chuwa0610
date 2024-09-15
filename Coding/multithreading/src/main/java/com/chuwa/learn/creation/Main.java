package com.chuwa.learn.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MyRunnable b = new MyRunnable();
        new Thread(b){
            @Override
            public void run(){
                System.out.println("print cc");
            }
        }.start();
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();
//
//        Thread.currentThread().setName("主线程");
//
//        for (int i = 0; i<5; i++){
//            System.out.println(Thread.currentThread().getName() + " " +i);
//        }
//        MyThread t1 = new MyThread();
//        t1.start();
//        MyRunnable runnable = new MyRunnable();
//        new Thread(runnable){}.start();
        // user implements Callable
        // 1. new our callable implementation class

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 创建Callable对象任务
        Callable<Integer> callableTask = () -> {
            System.out.println("Inside Callable");
            return 123;
        };

        // 开始执行线程
        Future<Integer> future = executor.submit(callableTask);

        try {
            // 获取Callable任务的结果
            Integer result = future.get();
            System.out.println("Result of the Callable: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executor.shutdown();
    }
}
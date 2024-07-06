package com.chuwa.learn.creation;

public class MyRunnable implements Runnable {
    @Override
    public void run(){
        Thread.currentThread().setName("BB run");
        for(int i = 0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

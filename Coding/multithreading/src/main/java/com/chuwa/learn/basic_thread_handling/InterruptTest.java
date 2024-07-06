package com.chuwa.learn.basic_thread_handling;

import org.junit.jupiter.api.Test;


class MyThreadWithIsInterrupted extends Thread{
    @Override
    public void run(){
        int n = 0;
        // isInterrupted() 是 Thread 自带的方法, 当线程被其他线程中断时返回true
        while(!isInterrupted()){
            n++;
            System.out.println(n+" hello!");
        }
    }
}

class WhileTrue extends Thread{
    @Override
    public void run(){
        int n = 0;
        while(true){
            n++;
            System.out.println(n+ " hello!");
        }
    }
}

class SleepForever extends Thread{
    @Override
    public void run(){
        int n = 0;
        try{
            Thread.sleep(5000 * 5000);
        }catch(InterruptedException e){
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}
class InterruptTest {
    @Test
    public void testIsInterrupted() throws InterruptedException {
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);
    }

    @Test
    public void testInterruptWhileTrue() throws InterruptedException{
        Thread t = new WhileTrue();
        execute(t);
    }

    @Test
    public void testInterruptSleep() throws InterruptedException{
        Thread t = new SleepForever();
        execute(t);
    }

    private void execute(Thread t) throws InterruptedException{
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        // join 让主线程阻塞，t thread 执行直到结束
        t.join();
        System.out.println("end");
    }
}

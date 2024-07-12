package com.chuwa.learn.waitNotify;

public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;
    static class PrintRunnable implements Runnable{
        @Override
        public void run(){
            synchronized (monitor){
                while(value <= 10){
                    System.out.println(Thread.currentThread().getName()+": " + value++);
                    monitor.notifyAll();
                    try{
                        while (value < 11) {
                            monitor.wait();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

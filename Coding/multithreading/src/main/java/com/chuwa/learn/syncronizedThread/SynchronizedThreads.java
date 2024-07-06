package com.chuwa.learn.syncronizedThread;

class Counter{
    // 使用static，可以同步一个类的所有实例之间的操作
    // 如果想要不同实例之间的线程不会互相影响，用实例锁
    // 锁定义成final，防止被意外更改了锁的引用
    // 如果使用runnable 实现thread,可以使用this,因为是在复用一个runnable; 使用继承的方法创建线程，每一个线程都是新的instance，不可以使用this
    public static final Object LOCK_STUDENT = new Object();
    public static final Object LOCK_TEACHER = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            // 同步监视器--锁
            // 同步监视器可以使用任何一个类对象
            // 多个线程必须使用同一个监视器
            synchronized (Counter.LOCK_STUDENT){
                // 需要被同步的代码
                // 操作共享数据的代码
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_STUDENT){
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_TEACHER) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            synchronized (Counter.LOCK_TEACHER){
                Counter.teacherCount -= 1;
            }
        }
    }
}

public class SynchronizedThreads {
    public static void main(String[] args) {
        Thread[] ts = new Thread[]{
                new AddStudentThread(),
                new DecStudentThread(),
                new AddTeacherThread(),
                new DecTeacherThread()
        };
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }
}

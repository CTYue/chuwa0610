package com.chuwa.learn.multithread.hw5.c01_create;

import java.util.concurrent.Callable;
public class MyCallable implements  Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello World";
    }
}

package com.chuwa.learn.creation;

import java.util.concurrent.Callable;

/**
 * @author b1go
 * @date 3/21/22 9:04 AM
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
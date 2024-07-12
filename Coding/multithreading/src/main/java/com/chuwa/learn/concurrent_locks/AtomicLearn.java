package com.chuwa.learn.concurrent_locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class IdGenerator{
    AtomicLong var = new AtomicLong(0);
    public long getNextId() {
        return var.incrementAndGet();
    }
}
public class AtomicLearn {
   public int incrementAndGet(AtomicInteger var){
       int prev, next;
       do {
           prev = var.get();
           next = prev + 1;
       } while ( ! var.compareAndSet(prev, next));
       return next;
   }
}

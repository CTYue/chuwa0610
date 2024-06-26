## 2. Write a thread-safe singleton class
```
public class Singleton {

   // Static volatile variable
   private static volatile Singleton instance;

   // Private constructor
   private Singleton() {}

   // Static synchronized getInstance method
   public static Singleton getInstance() {
      if(instance == null) {
         synchronized(this) {
            if(instance == null){
               instance = new Singleton();
            }
         }
      }
      return instance;
   }
}
```

## 3. How to create a new thread(Please also consider Thread Pool approach)?
- Extends Thread class
```
public class MyThread extends Thread {
   @Override
   public void run() {
      System.out.println("Starting a new thread...");
   }
}
```
- Implements Runnable
```
public class myRunnable implements Runnable {
   @Override
   public void run() {
      System.out.println("Starting a new thread...");
   }
}
```
- Implements Callable
```
public class MyCallable implements Callable<String> {
   @Override
   public String call() throws Exception {
      Thread.sleep(2000);
      return "Starting a new thread...";
   }
}
```
- Lambda Expression
```
Thread thread = new Thread(() -> {
   System.out.println("Starting a new thread...");
})
```
- Thread Pool
```
ExecutorService executor = Executors.newFixedThreadPool(4);
executor.submit();
```

## 4. Difference between Runnable and Callable?
Runnable has a run() method and does not return anything. Callable has a call() method and returns a value. Callable allows use to specify the type of result that will be returned by the call() method. When a callable is submitted to an ExecutorService, it returns a Future object that can be used to retrieve the result of the computation. run() method in Runnable interface cannot throw a checked exception, call() method in Callable interface can throw an exception.

## 5. What is the difference betweent.start() and t.run()?
`t.start()` starts a new thread and `run()` method is executed on the newly created thread. `t.run()` cannot create a new thread, and the `run()` executes the task in the current thread.

## 6. Which way of creating threads is better: Thread class or Runnable interface?
Creating threads by implementing Runnable interface is preferred. Because when extending the Thread class, we are not forced to overriding any of its method. However, we have to override the run() method of Runnable interface.

Creating a class that implements Runnable interface and passing it to the Thread class utilizes composition instead of inheritance, which is more flexiable.

We cannot extend any other class if we extend the Thread class.
Runnable interface can also be used as lambda expression.

## 7. What are the thread status?
- **NEW** - a newly created thread that has not yet started the execution.
- **RUNNABLE** - either running or ready for execution but it's waiting for resource allocation.
- **BLOCKED** - waiting to acquire a monitor lock to enter or re-enter an synchronized block/method.
- **WAITING** - waiting for some other thread to perform a particular action without any time limit.
- **TIMED_WAITING** - waiting for some other thread to perform a specific action for a specified period.
- **TERMINATED** - has completed its execution.

## 8. Demonstrate deadlock and how to resolve it in Java code.
Deadlock:
```
public class DeadLock {
   public static void main(String[] args) throws InterruptedException {
      Thread[] ts = new Thread[] {
               new Thread(() -> {
                  while(true) {
                     Counter.add(2);
                  }
               }),
               new Thread(() -> {
                  while(true) {
                     Counter.dec(2);
                  }
               }),
      };
      for (Thread t : ts) {
         t.start();
      }

      for (Thread t : ts) {
         t.join();
      }

      System.out.println("main end");
   }
}

/**
* Locker
*/
class Counter {
   public static final Object LOCK_A = new Object();
   public static final Object LOCK_B = new Object();
   private static int value = 0;
   private static int another = 0;

   public static void add (int m) {
      synchronized (LOCK_A) {
            value += m; // A
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            synchronized (LOCK_B) {
               another += m;
            }
      }

      System.out.println("value is: " + value + ", another is: " + another);
   }

   public static void dec(int m) {
      synchronized (LOCK_B) {
            another -= m; //B
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            synchronized (LOCK_A) {
               value -= m;
            }
      }

      System.out.println("value is: " + value + ", another is: " + another);
   }
}
```
In order to resolve deadlock, we need to make sure lock order for all threads are the same:
```
public static void dec(int m) {
      // Change LOCK_B to LOCK_A 
      synchronized (LOCK_A) {
            another -= m; //B
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            synchronized (LOCK_B) {
               value -= m;
            }
      }

      System.out.println("value is: " + value + ", another is: " + another);
   }
```

## 9. How do threads communicate with each other?
Threads can communicate with each other by using wait and notify method.
```
public class OddEventPrinter {
   private static final Object monitor = new Object();
   private static int value = 1;

   public static void main(String[] args) {
      PrintRunnable runnable = new PrintRunnable();
      new Thread(runnable).start(); // t0
      new Thread(runnable).start(); // t1
   }

   static class PrintRunnable implements Runnable {
      @Override
      public void run(){
         synchronized(monitor) {
            while(value <= 10) {
               System.out.println(Thread.currentThread().getName() + ": " + value++);
               monitor.notifyAll();
               try {
                  monitor.wait();
               } catch (InterruptedException e){
                  e.printStackTrace();
               }
            }
         }
      }
   }
}
```

## 10. What’s the difference between class lock and object lock?

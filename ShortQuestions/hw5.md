## 1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

## 2. Write a thread-safe singleton class

```java
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

```java
// Extends Thread class
public class MyThread extends Thread {
   @Override
   public void run() {
      System.out.println("Starting a new thread...");
   }
}

// Implements Runnable
public class myRunnable implements Runnable {
   @Override
   public void run() {
      System.out.println("Starting a new thread...");
   }
}

// Implements Callable
public class Foo implements Callable{
    @Override
    public String call() throws Exception
         ...
    }
    Thread t = new Thread(new Foo());
}

// Thread Pool
ExecutorService executor  = new Executors.newFixedThreadPool(10);
executor .submit(new // add runable...);
```

## 4. Difference between Runnable and Callable?

Callable

* has return values
* It can throw checked exceptions. 

Runnable

* has no return values
* It cannot throw checked exceptions. 

## 5. What is the difference between t.start() and t.run()?

- t.start() starts a new thread and it the calls run() to run the thread. 
- t.run() cannot create a new thread, and it just run the code in the run() method.

## 6. Which way of creating threads is better: Thread class or Runnable interface?

Implementing Runnable interface is preferred. 

1) If we implement Runnable class we can still extend another class.

2) We force to override the run() method of Runnable interface.

3) We can also use lambda expression with Runnable interface.

## 7. What are the thread statuses?

NEW: A thread that has been created but has not yet started executing.

RUNNABLE: A thread that is either currently executing or ready to execute but is waiting for resource allocation.

BLOCKED: A thread that is waiting to acquire a monitor lock to enter or re-enter a synchronized block or method.

WAITING: A thread that is waiting indefinitely for another thread to perform a specific action (e.g., calling Object.wait()).

TIMED_WAITING: A thread that is waiting for another thread to perform a specific action within a specified time period (e.g., Thread.sleep(time)).

TERMINATED: A thread that has completed its execution.

## 8. Demondtrate deadlock and how to resolve it in Java code.

```java
public class DeadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

## 9. How do threads communicate each other?

* wait() -- Causes the current thread to wait until another thread calls notify() or notifyAll() on the same object.
* notify() -- Wakes up a single thread that is waiting on the object's monitor.
* notifyAll() -- Wakes up all threads that are waiting on the object's monitor.

## 10. What’s the difference between class lock and object lock?

Object Lock:

* An object lock is tied to a specific instance of a class.
* When a thread acquires an object lock, it can access synchronized instance methods of that particular object.
* Other threads can access synchronized methods of other instances of the class but cannot access synchronized methods of the same instance until the lock is released.

Class Lock:

* A class lock is tied to the Class object associated with the class.
* When a thread acquires a class lock, it can access synchronized static methods of the class.
* Other threads cannot access synchronized static methods of the class until the lock is released, regardless of the instance.

## 11. What is join() method?

* With Join() method, the Main thread will stop and wait for thread t completes its task

## 12. what is yield() method

* The join() method in Java is used to pause the execution of the current thread until the thread on which join() was called has finished executing. This ensures that one thread waits for another thread to complete before continuing its own execution. The method can also take a time parameter, specifying how long to wait for the thread to finish.

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

ThreadPool:

* A ThreadPool in Java is a pool of worker threads that are reused to execute multiple tasks. It helps in managing and limiting the number of threads running concurrently, which improves performance and resource management.

Types of ThreadPool:

* FixedThreadPool: A pool with a fixed number of threads.
* CachedThreadPool: A pool that creates new threads as needed but reuses previously constructed threads when available.
* SingleThreadExecutor: A pool with a single worker thread.
* ScheduledThreadPool: A pool for scheduling tasks to run after a given delay or periodically.

TaskQueue in ThreadPool:

* The TaskQueue is a blocking queue used to hold tasks before they are executed by the worker threads in the ThreadPool. It helps in managing the tasks waiting to be executed and controls the flow of task execution based on the availability of threads.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

* Library: The java.util.concurrent library is used to create ThreadPools in Java.
* Interface: The ExecutorService interface provides the main functions of a thread pool, such as submitting tasks, managing the pool, and shutting it down.

## 15. How to submit a task to ThreadPool?

* execute(Runnable task): Submits a Runnable task for execution but does not return a result.
* submit(Runnable task): Submits a Runnable task for execution and returns a Future<?> representing the task.

## 16. What is the advantage of ThreadPool?

* Resource Management: Limits the number of concurrent threads, preventing resource exhaustion.
* Improved Performance: Reuses existing threads, reducing the overhead of creating and destroying threads.
* Task Scheduling: Manages the scheduling and execution of tasks efficiently.
* Simplified Coding: Provides a higher-level abstraction for managing threads, simplifying the development of concurrent applications.
* Scalability: Better handles varying workloads by dynamically managing the number of threads based on demand.

## 17. Difference between shutdown() and shutdownNow() methods of executor

shutdown():

* Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
* The executor will stop accepting new tasks and will wait for currently executing tasks to complete.
  shutdownNow():
* Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of tasks that were awaiting execution.
* It interrupts all running tasks and clears the task queue.

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

* Atomic Classes:
  Atomic classes in Java are part of the java.util.concurrent.atomic package. They provide a way to perform atomic operations on single variables without using synchronization. These classes ensure that the operations on the variables are thread-safe and lock-free, making them useful in concurrent programming.

* AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference, AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

* Concurrent collections in Java are specialized data structures designed to handle concurrent access in a multi-threaded environment.
* ConcurrentHashMap, ConcurrentLinkedQueue, CopyOnWriteArrayList, CopyOnWriteArraySet, ConcurrentSkipListMap.

## 20. What kind of locks do you know? What is the advantage of each lock?

* Synchronized, ReentrantLock, StampedLock, ReadWriteLock

## 21. What is future and completableFuture? List some main methods of ComplertableFuture.

* Future is a blocking way of multithreading. CompletableFuture is a non-blocking way of multithreading
* supplyAsync(Supplier<U> supplier): Runs a task asynchronously and returns a result.
* thenApply(Function<T, U> fn): Transforms the result of the future when it completes.
* thenAccept(Consumer<T> action): Consumes the result of the future when it completes.
* exceptionally(Function<Throwable, ? extends T> fn): Handles exceptions that occur during the computation.
* complete(T value): Manually completes the future with a given value.

## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

1) One solution use synchronized and wait notify 
2) One solution use ReentrantLock and await, signal

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is com.chuwa.exercise.t08_multithreading.PrintNumber1)

## 25. completable future:

1) Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum 
   and product of two integers, and print the results.
2) Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
   1. Sign In to Developer.BestBuy.com
   2. Best Buy Developer API Documentation (bestbuyapis.github.io)
   3. 可以⽤fake api https://jsonplaceholder.typicode.com/
3) Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information

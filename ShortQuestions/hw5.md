# HW5

**Write a thread-safe singleton class**

Double-checked locking

Synchronized when instance is  Initialized

```java
public class Singleton{
	private static volatile Singleton instance;
	private Singleton(){}
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					 instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
```

Eager initialization

Create instance when class is loading

```java
public class EagerSingleton{
	private static final EagerSingleton INSTANCE = new EagerSingleton();
	private EagerSingleton(){}
	public static EagerSingleton getInstance(){
		return INSTANCE;
	}
}
```

Lazy initialization

和double check 相比性能较差，因为每次获取实例时都需要同步

```java
public class LazySingleton{
	private static LazySingleton instance;
	private LazySingleton(){}
	public static synchronized LazySingleton getInstance(){
			if(instance == null){
					instance = new LazySingleton();
			}
			return instance;
	}
}
```

**How to create a new thread(Please also consider Thread Pool approach)?**

- Inherit Thread class and override run()

```java
public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Start new thread");
    }
}
 MyThread t1 = new MyThread();
 t1.start();
```

- Use Runnable interface to implement runnable instance, and send runnable instance into Thread instance

```java
public class MyRunnable implements Runnable {
    @Override
    public void run(){
        Thread.currentThread().setName("BB run");
        for(int i = 0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
MyRunnable runnable = new MyRunnable();
new Thread(runnable){}.start();
```

- Use Callable interface and work with Thread pool

```java
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
```

**Difference between Runnable and Callable?**

Runnable interface doesn’t return value: void run()

Callable interface can return value: V call() throws Exception

Callable is suitable for more complicated situation, like the concurrent tasks which need to process the return result.

**What is the difference between t.start() and t.run()?**

t.start() will create a thread and attaches it to instance t, once the set up is done , run() will be called, the run() method will execute independently of the main thread’s flow.

t.run() is just like other method in the thread task, when you call t.run(), you call a method on the current thread. In the thread creation, we may override the native run().

**Which way of creating threads is better: Thread class or Runnable interface?**

Use runnable interface would be better, because it can avoid the limitation of single inheritance. If the instance has already inherit Thread, they can not inherit other class.

And use Runnable interface will be more suitable for resource sharing and thread pool.

**What are the thread statuses?**

Thread status is states during the lifecycle.

NEW: The thread has been created but has not yet started

Runnable: The thread is ready to run and is waiting for CPU time, including actually running

BLOCKED: The thread is blocked waiting for a monitor lock

WAITING: The thread is waiting indefinitely for another thread’s action

TIMED_WAITING: The thread is waiting for another thread’s action for a specified time

TERMINATED: Thread has finished

**Demonstrate deadlock and how to resolve it in Java code.**

不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃资源

 **How do threads communicate each other?**

1. Use wait() and notify()/notifyAll()
2. Lock
3. Use concurrent Data structures, like ConcurrentHashMap
4. Condition variable(use with lock)

**What’s the difference between class lock and object lock?**

Class lock is used to synchronize static methods or block within a static method,

eg:

```java
public class Example {
    private static int staticCounter = 0;
    private int instanceCounter = 0;

    public static synchronized void incrementStatic() {
        staticCounter++;  // Synchronized on the class lock
    }
}
```

Object lock is used to a non-static method or block,

eg

```java
public class Example {
    private static int staticCounter = 0;
    private int instanceCounter = 0;

    public static synchronized void incrementStatic() {
        staticCounter++;  // Synchronized on the class lock
    }

    public synchronized void incrementInstance() {
        instanceCounter++;  // Synchronized on the object (instance) lock
    }
}
```

**What is join() method?**

n threads, methods such as sleep(), join(), and yield() only affect the thread that executes them.

When join() is called on thread B from thread A, it means that thread A enters a blocked state until thread B completes its execution. After thread B finishes, thread A resumes and continues its execution.

One application scenario is when thread A needs to wait for the results from thread B. This can be achieved by calling join() on thread B, and after obtaining the results, thread A can continue executing.

**what is yield() method?**

The CPU temporarily give up control, allowing other threads to execute.

**What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?**

FixThreadPool:

A thread pool with a fixed number of threads.

cachedThreadPool,

The thread pool creates new threads as needed but will reuse the previous threads when they are availiable.  If a thread remains idle for a certain time (60 seconds by default), it is terminated and removed from the cache. 

SingleThreadPool,

A thread pool with only one thread to ensure that tasks are executed sequentially in the order they are submitted. 

ScheduleThreadPool,

A thread pool designed to schedule commands to run after a given delay, or to execute periodically. This is useful for recurring tasks such as timers and scheduled tasks

CustomThreadPool

The thread pool with custom settings.

The task queue in thread pool is a queue of tasks (runnable or callable) that are waiting to be executed by the worker threads. 

Apart from CustomThreadPool, other method has built in task queue.

**Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?**

java.util.concurrent package, we may use Executors, ThreadPoolExecutor, ScheduledThreadPoolExecutor

**How to submit a task to ThreadPool?**

```java
// create a threadpool
ExecutorService executor = Executors.newFixedThreadPool(4);
// submit tasks
executor.execute(() -> {
    System.out.println("Simple task executed using execute method");
});
//Or
Future<?> future = executor.submit(() -> {
    System.out.println("Simple task executed using submit method");
});
```

**What is the advantage of ThreadPool?**

1. Reduce resource consumption and controlled resource allocation. Since creating and destroying thread can be expensive, and thread pool limit the number of thread running concurrently, which prevent excessive use of CPU and memory.
2. Increased responsiveness and load distribution. By reusing existing threads rather than starting new one, thread pool can significantly reduce the latency.
3. Simplified task management. Thread pool provide a way to queue up tasks that execute as soon as a thread becomes available.
4. Error handing and robustness. Thread pool can isolate error-handing to specific tasks, which can prevent a single failing task from affecting others.
5. Resource clean-up and shutdown. Thread pools provide mechanism to shutdown the pool, ensuring all tasks are completed before the application closes.

**Difference between shutdown() and shutdownNow() methods of executor**

shutdown() initiates a graceful shutdown, which previously submitted tasks are executed, but no new tasks will be accepted. It does not cause immediate disruption to tasks are currently running and the method will return immediately and the tasks will complete in background.

shutdownNow() attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.

**What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?**

Basic types: AtomicBoolean, AtomicInteger, AtomicLong

Array types: AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray

Reference types: AtomicReference, AtomicStampedReference, AtomicMarkableReference

Field updates: AtomicIntegerFieldUpdater,AtomicLongFieldUpdater,AtomicReferenceFieldUpdater

Atomic is used in concurrency environments, it provides classes that support lock-free thread-safe programming on single variables. It utilize low-level synchronization primitives provided by hardware. Atomic is suitable for single operations in high-concurrency environment.

Atomic method:

```java
public class AtomicLearn {
    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        return next;
    }
}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
```

**What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)**

Concurrent collections are collections which support simultaneous access by multiple threads without the need for external synchronization.

eg: ConcurrentHashMap, ConcurrentLinkedQueue, ConcurrentLinkedDequeue etc

**What kind of locks do you know? What is the advantage of each lock?**

ReentrantLock, ReadWriteLock, StampedLock

Compared with synchronized, ReentrantLock is more safe since it will not caused dead lock if tryLock() failed.

ReadWriteLock enable multi thread read data if there is no write thread, which is more efficient in read>write scenario.

Compared with ReadWriteLock, StampedLock enable read thread gets data when there is a write thread is working, it use validate() to check the version number, if the version number changed means the data is modified, the read thread will read data again, it will be more faster than readWrite lock.

**What is future and completableFuture? List some main methods of CompletableFuture.**

Future represent the result of an asynchronous computation. A Future provides methods to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation.

CompletableFuture is an enhancement of Future, which enable multi thread in multi batch processing, which future only enables multi thread in single batch process. CompletableFuture is more easy to use.
package multithreading;

/**
 * description: OddEventPrinter
 * date: 6/24/24 9:30 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class OddEventPrinter {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Thread-1: "+ i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Thread-2: "+ i);                }
        }).start();
    }
}


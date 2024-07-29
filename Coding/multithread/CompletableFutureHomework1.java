import java.util.concurrent.CompletableFuture;

public class CompletableFutureHomework1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));
        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}
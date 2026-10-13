package org.example;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {

                    System.out.println(
                            "First task: " +
                                    Thread.currentThread().getName()
                    );

                    return "Java";
                });

        CompletableFuture<String> result =
                future.thenApply(value -> {

                    System.out.println(
                            "Second task processing..."
                    );

                    return value + " Multithreading";
                });

        System.out.println(
                "Result: " + result.join()
        );
    }
}


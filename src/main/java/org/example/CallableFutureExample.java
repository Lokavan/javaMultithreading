package org.example;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {

            System.out.println(
                    "Calculating using: " +
                            Thread.currentThread().getName()
            );

            return 10 + 20;
        };

        Future<Integer> future =
                executor.submit(task);

        System.out.println("Waiting for result...");

        Integer result = future.get();

        System.out.println("Result = " + result);

        executor.shutdown();
    }
}
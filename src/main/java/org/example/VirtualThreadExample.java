package org.example;

public class VirtualThreadExample {

    public static void main(String[] args)
            throws InterruptedException {

        Thread virtualThread =
                Thread.startVirtualThread(() -> {

                    System.out.println(
                            "Hello from virtual thread"
                    );

                    System.out.println(
                            "Is virtual: " +
                                    Thread.currentThread().isVirtual()
                    );

                });

        virtualThread.join();
    }
}

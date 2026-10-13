package org.example;

class MyTask implements Runnable {

    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    taskName +
                            " - Count: " + i +
                            " - Thread: " +
                            Thread.currentThread().getName()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


public class RunnableExample {

    public static void main(String[] args) {

        MyTask task1 = new MyTask("Download");
        MyTask task2 = new MyTask("Email");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println(
                "Main thread: " +
                        Thread.currentThread().getName()
        );
    }
}
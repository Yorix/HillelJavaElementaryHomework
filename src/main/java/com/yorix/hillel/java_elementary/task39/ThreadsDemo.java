package com.yorix.hillel.java_elementary.task39;

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Hello To My Multithreading World:"));
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
            }
            System.out.print(" start: ");
        });
        InputTask inputTask = new InputTask();
        Thread t3 = new Thread(inputTask);
        Thread t4 = new Thread(() -> System.out.printf("My name is %s\n", inputTask.getUserName()));


        t3.start();
        t2.start();
        t1.start();

        t3.join();

        t4.start();
    }
}

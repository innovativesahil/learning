package com.sahil.learning.multithreading;

import org.jetbrains.annotations.NotNull;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Math.abs(1);
        Thread thread = new Thread(() -> {
            try {
                SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is running " + Thread.currentThread().getName());
        });

        thread.start();
        thread.join();

        Thread myThread1 = new MyThread("custom-thread-1");
        Thread myThread2 = new MyThread("custom-thread-2");
        Thread myThread3 = Thread.ofVirtual().name("virtual").start(ThreadDemo::run);
        myThread1.start();
        myThread2.start();

    }

    public static void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running " + i + " " + Thread.currentThread().getName());
            try {
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread completed " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {

        public MyThread(@NotNull String name) {
            super(name);
        }

        public void test(){

        }

        @Override
        public void run() {
            ThreadDemo.run();
        }
    }
}

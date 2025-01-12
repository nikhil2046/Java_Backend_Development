package com.exercise.programs.multithreading.completable_future;

import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CompletableFutureDemo {
    public String getName() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Hello Nikhil..!";
    }

    public String getMessge() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Welcome To Jungle..!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFutureDemo demo = new CompletableFutureDemo();


        CompletableFuture<String> futureName = CompletableFuture.supplyAsync(() -> {
            return demo.getName() + " Thread : "+Thread.currentThread().getName();

        },executorService);

        CompletableFuture<String> futureMssg = supplyAsync(() -> {
            return demo.getMessge() + " Thread : "+Thread.currentThread().getName();
        },executorService);

        String name = futureName.get();
        System.out.println(name);

        String msg = futureMssg.get();
        System.out.println(msg);
    }
}

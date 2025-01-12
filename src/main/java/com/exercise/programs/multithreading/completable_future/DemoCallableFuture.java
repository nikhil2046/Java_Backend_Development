package com.exercise.programs.multithreading.completable_future;

import java.util.concurrent.*;

public class DemoCallableFuture {
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
        System.out.println("Hello main page 1.");
        DemoCallableFuture future = new DemoCallableFuture();
        Callable<String> callableName = () -> {
            return future.getName() + " Thread Name : "+Thread.currentThread().getName();
        };

        Callable<String> callableMessage = () -> {
            return future.getMessge() + " Thread Name : "+Thread.currentThread().getName();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> futureName = executorService.submit(callableName);
        Future<String> futureMessage =   executorService.submit(callableMessage);
        String name = futureName.get();
        String messg = futureMessage.get();
        System.out.println(name + " : \n"+messg);
        System.out.println("Hello main page 2");
        executorService.shutdown();

    }
}

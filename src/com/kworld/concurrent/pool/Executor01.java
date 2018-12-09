package com.kworld.concurrent.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Executor01 {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            System.out.println(Thread.currentThread().getId());
        });

        executor.execute(()->{
            System.out.println(Thread.currentThread().getId());
        });

    }
}

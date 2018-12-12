package com.kworld.concurrent.pool;

import static com.kworld.util.Util.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor01 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
			executor.execute(() -> logger.info(Thread.currentThread().getId() + ""));
			executor.execute(() -> logger.info(Thread.currentThread().getId() + ""));
		} finally {
			executor.shutdown();
		}

    }
}

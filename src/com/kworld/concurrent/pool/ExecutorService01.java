package com.kworld.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.kworld.util.Util.logger;
public class ExecutorService01 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
			executor.execute(() -> {
				logger.info("1" + Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				logger.info("1" + Thread.currentThread().getId());
			});
			executor.execute(() -> {
				logger.info("2" + Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				logger.info("2" + Thread.currentThread().getId());
			});
		} finally {
			executor.shutdown();
		}
    }
}

package com.kworld.concurrent.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.kworld.util.Util.logger;
public class CountDownLacheTimeCalculator {
	
	public static void main(String[] args) throws InterruptedException {
		int concurrency = 10;
		ExecutorService executor = Executors.newFixedThreadPool(concurrency);
		try {
			long time = calculateTime(executor, concurrency, ()-> {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
			});
			logger.info("Total time taken to complete work is : " + time + " nano sec");
		} finally {
			executor.shutdown();
		}
	}

	private static long calculateTime(Executor executor, int concurrency, Runnable runnable) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		for (int i = 0; i < concurrency; i++) {
			executor.execute(()->{
				ready.countDown();//Each worker get ready and wait on next line => 2.
				try {
					start.await(); //wait for all to get ready => 3.
					runnable.run(); // => 6.
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					done.countDown(); //Each task is done  => 7.
				}
			});
		}
		ready.await(); //wait for all worker to ready => 1.
		long startTime = System.nanoTime();
		start.countDown();  //=> 4.
		done.await();//Wait for all to complete work => 5.
		return System.nanoTime() - startTime;   // => 8.
	}
	
	
}

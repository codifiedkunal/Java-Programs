package com.kworld.thread.runnable;

import static com.kworld.util.Util.logger;
public class IntrinsicLock {

	private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        IntrinsicLock intrinsicLock = new IntrinsicLock();
        Thread t1 = new Thread(()->{
            for (int i = 0 ;i< 100; i++) {
                intrinsicLock.incrementCount();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0 ;i< 100; i++) {
                intrinsicLock.incrementCount();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        logger.info(String.valueOf(count));
    }

    public synchronized void incrementCount() {
        count++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package com.kworld.thread.runnable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLock {
    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter = new OddEvenLock().new OddEvenPrinter(100);
        Thread odd = new Thread(()->{
                try {
                    oddEvenPrinter.printOdd();
                } catch (InterruptedException e) {
                	Thread.currentThread().interrupt();
                }
        });

        Thread even = new Thread(()->{
            try {
                oddEvenPrinter.printEven();
            } catch (InterruptedException e) {
            	Thread.currentThread().interrupt();
            }
        });

        even.start();
        odd.start();

    }

    class OddEvenPrinter {
        private boolean isOdd = false;
        private long counter = 0 ;
        private final long max;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        OddEvenPrinter(long max){
            this.max = max;
        }

        public void printOdd() throws InterruptedException {
            while (counter < max) {
                try {
                    lock.lock();
                    while (!isOdd) {
                        condition.await();
                    }
                    System.out.println("Odd : " + counter);
                    incrementAndSetOddEven();
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        void incrementAndSetOddEven() {
            counter++;
            isOdd = (counter%2) != 0;
        }

        public void printEven() throws InterruptedException {
            while (counter < max) {
                try {
                    lock.lock();
                    while (isOdd) {
                        condition.await();
                    }
                    System.out.println("Even : " + counter);
                    incrementAndSetOddEven();
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
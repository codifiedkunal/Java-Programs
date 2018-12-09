package com.kworld.thread.runnable;

public class OddEvenIntrinsic {
    public static void main(String[] args) throws InterruptedException {
        OddEvenPrinter oddEvenPrinter = new OddEvenIntrinsic().new OddEvenPrinter(101);
        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrinter.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrinter.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        even.start();
        odd.start();

    }

    class OddEvenPrinter {
        private boolean isOdd = false;
        private long counter = 0 ;
        private final long max;

        OddEvenPrinter(long max){
            this.max = max;
        }

        public void printOdd() throws InterruptedException{
            synchronized (this){
                while (counter < max){
                    while(!isOdd) {
                        this.wait();
                    }
                    System.out.println("Odd: " + counter);
                    increment();
                    notify();
                }
            }
        }

        void increment() {
            counter++;
            isOdd = (counter%2) != 0;
        }

        public void printEven() throws InterruptedException{
            synchronized (this){
                while (counter < max){
                    while(isOdd) {
                        this.wait();
                    }
                    System.out.println("Even: " + counter);
                    increment();
                    notify();
                }
            }
        }
    }
}
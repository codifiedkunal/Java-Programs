package com.kworld.thread.runnable;

import java.util.stream.IntStream;

class Runner implements Runnable{
    @Override
    public void run() {
        IntStream.range(0,100).forEach(i->{
            System.out.println(Thread.currentThread().getId() + " : " +  i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            	Thread.currentThread().interrupt();
            }
        });
    }
}

public class RunnableExample {
    public static void main(String [] args){
        new Thread(new Runner()).start();
        new Thread(new Runner()).start();
    }
}

package com.kworld.problems.series.fabonnaci;

import static com.kworld.util.Util.logger;
import static com.kworld.util.Util.scanner;
/*
Print fibonacci series upto a number
 */
public class FibonacciSeriesSimple {
    public static void main(String[] args) {
    	logger.info("Enter No upto which Fibbonacci Series to print : ");
        Integer maxNo = scanner.nextInt();

        new FibonacciSeriesSimple().printFibonacci(maxNo);
    }

    private void printFibonacci(Integer maxNo) {
        Integer first = 1;
        Integer second = 1;
        if(first < maxNo)
        	logger.info(String.format("%s%n", first));
        if(second < maxNo)
        	logger.info(String.format("%s%n", second));
        second = first + second;
        while(first+second < maxNo){
        	logger.info(String.format("%s%n", second));
            first = second - first;
            second = first + second;
        }
    }
}

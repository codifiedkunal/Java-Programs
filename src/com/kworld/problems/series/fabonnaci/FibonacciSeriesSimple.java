package com.kworld.problems.series.fabonnaci;

import static com.kworld.util.Util.scanner;
/*
Pring Febonnaci series upto a number
 */
public class FibonacciSeriesSimple {
    public static void main(String[] args) {
        System.out.print("Enter No upto which Fibbonacci Series to print : ");
        Integer maxNo = scanner.nextInt();

        new FibonacciSeriesSimple().printFibonacci(maxNo);
    }

    private void printFibonacci(Integer maxNo) {
        Integer first = 1;
        Integer second = 1;
        if(first < maxNo)
            System.out.println(first);
        if(second < maxNo)
            System.out.println(second);
        second = first + second;
        while(first+second < maxNo){
            System.out.println(second);
            first = second - first;
            second = first + second;
        }
    }
}

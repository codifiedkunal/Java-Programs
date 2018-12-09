package com.kworld.problems.series.fabonnaci;

import static com.kworld.util.Util.scanner;

/*
Print n Febonnaci nos in series
 */
public class FibonaciSeriesRecursive {
    public static void main(String[] args) {
        System.out.print("Enter number to items to print in Fibonacci Series : ");
        Integer maxNo = scanner.nextInt();

        System.out.println("\n\nFibonnaci Using Recursive ");
        for (int i = 1; i <= maxNo ; i++){
            System.out.print(fibbonacciOf(i) + " ");
        }

        System.out.println("\n\nFibonnaci Using Simple Function ");
        for (int i = 1; i <= maxNo ; i++){
            System.out.print(fibonacciSimple(i) + " ");
        }
    }

    private static Integer fibonacciSimple(Integer i) {
        int first, second;
        first = second = 1;
        if(i == 1 || i == 2)
            return first;
        int count = 3;
        while(count <= i) {
            second = first + second;
            first = second - first;
            count++;
        }
        return second;
    }

    private static Integer fibbonacciOf(Integer i) {
        if( i == 1 || i == 2)
            return 1;
        return fibbonacciOf(i-1 ) + fibbonacciOf(i - 2);
    }
}

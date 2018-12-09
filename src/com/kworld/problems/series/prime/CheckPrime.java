package com.kworld.problems.series.prime;

import static com.kworld.util.Util.scanner;
/*
 Given Number N Check if it is prime
 */
public class CheckPrime {
    public static void main(String[] args) {
        System.out.print("Enter Number N to check if prime : ");
        int n = scanner.nextInt();

        System.out.printf("Is Number [%d] prime %s \n", n, (checkPrimeWay1(n) == true ? "YES" : "NO"));

        System.out.printf("Is Number [%d] prime %s \n", n, (checkPrimeWay2(n) == true ? "YES" : "NO"));

        System.out.printf("Is Number [%d] prime %s \n", n, (checkPrimeWay3(n) == true ? "YES" : "NO"));
    }

    private static boolean checkPrimeWay3(int n) {
        if( n == 2 || n == 3)
            return true;
        if( n % 2 == 0)
            return false;
        int sqrt = (int)Math.sqrt(n) + 1;
        for( int i = 3; i<= sqrt ; i = i + 2){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static boolean checkPrimeWay2(int n) {
        int sqrt = (int)Math.sqrt(n) + 1;
        for( int i = 2; i<= sqrt ; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static boolean checkPrimeWay1(int n) {
        for(int i = 2; i<= n/2; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}

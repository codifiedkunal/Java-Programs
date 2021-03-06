package com.kworld.problems.number;

import java.math.BigInteger;

import static com.kworld.util.Util.logger;
import static com.kworld.util.Util.scanner;
public class Factorial {
    public static void main(String[] args) {
    	logger.info("Enter Number n to find its Factorial : ");
        Integer n = scanner.nextInt();

        logger.info(String.format("Factorial of %d is %d", n, new Factorial().calculateFactorial(n)));

        logger.info(String.format("%n%nFactorial of %d is %d Using Recursion", n, new Factorial().calculateFactorialRecursively(n)));
    }

    private BigInteger calculateFactorialRecursively(Integer n) {
        if( n == 0 || n == 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(calculateFactorialRecursively(n - 1));
    }

    private BigInteger calculateFactorial(Integer n) {
        BigInteger factorial = BigInteger.valueOf(1);
        if(n == 0)
            return factorial;
        for (int i = 1; i <= n ;i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }
}

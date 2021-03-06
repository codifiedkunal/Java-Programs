package com.kworld.problems.number;

import static com.kworld.util.Util.logger;
import static com.kworld.util.Util.scanner;
public class Armstrong {
    public static void main(String[] args) {
    	logger.info("Enter Number to check if Armstrong :");
        long n = scanner.nextLong();
        logger.info(String.format(" %d is %s", n, new Armstrong().checkArmstrong(n) ? "Armstrong" : "Not Armstrong"));

        logger.info(String.format("%n %d is sum of digits of %d", new Armstrong().sumOfDigits(n), n));
    }

    private long sumOfDigits(long n) {
        long sum = n % 10;
        while((n = n / 10) > 0){
            sum = sum + n % 10;
        }
        return sum;
    }

    private boolean checkArmstrong(long n) {
        long temp = n;
        long m = getCubeOfReminder(temp);
        while((temp = temp / 10) > 0){
            m = m + getCubeOfReminder(temp);
        }
        return n == m;
    }

    private long getCubeOfReminder(long temp) {
        long reminder = temp % 10;
        return reminder * reminder * reminder;
    }
}

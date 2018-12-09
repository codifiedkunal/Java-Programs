package com.kworld.problems.arrays;

import com.kworld.util.Util;

public class FindPairWithSum {
    public static void main(String[] args) {
        int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
        int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
        System.out.print("Enter n to find sum ");
        int sum = Util.scanner.nextInt();
        new FindPairWithSum().findPairs(numbers, sum);
        System.out.println();
        new FindPairWithSum().findPairs(numbersWithDuplicates, sum);
    }

    private void findPairs(int[] numbers, int sum) {
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if(numbers [i] + numbers [j] == sum)
                    System.out.printf(" (%d, %d) ", numbers [i], numbers [j]);
            }
        }
    }
}

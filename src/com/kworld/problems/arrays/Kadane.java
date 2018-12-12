package com.kworld.problems.arrays;

import static com.kworld.util.Util.logger;

/**
 * Largest Sum of Contiguous Sub-Array, Using Kadane Algorithm
 */
public class Kadane {
    public static void main(String[] args) {

        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        logger.info(String.format("%nLargest Sum of Contiguous Sub-Array is %d", new Kadane().maxSubArraySum(arr)));
    }

    private int maxSubArraySum(int[] arr) {
        int maxEndingHere, maxSoFar;
        maxEndingHere = maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if(maxEndingHere < 0)
                maxEndingHere = 0;
            else if(maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
}

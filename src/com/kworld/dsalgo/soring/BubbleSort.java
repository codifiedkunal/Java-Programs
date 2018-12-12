package com.kworld.dsalgo.soring;


import com.kworld.util.Util;

import static com.kworld.util.Util.logger;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Integer [] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        logger.info(String.format("Array Before Soring %s %n", Arrays.toString(arr)));
        new BubbleSort().sortArray(arr);
        logger.info(String.format("Array After Soring %s %n", Arrays.toString(arr)));
    }

    private void sortArray(Integer [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j])
                    Util.swapValues(arr, j - 1, j);
            }
            logger.info(String.format("After Loop %2d %s %", i, Arrays.toString(arr)));
        }
    }
}

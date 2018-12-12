package com.kworld.dsalgo.soring;

import static com.kworld.util.Util.swapValues;
import static com.kworld.util.Util.logger;

import java.util.Arrays;

public class SelectionSort { 
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};
        logger.info(String.format("Array Before Soring : %s %n", Arrays.toString(arr)));
        new SelectionSort().sortArray(arr);
        logger.info(String.format("Array After Soring : %s %n", Arrays.toString(arr)));
    }

    private void sortArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            swapValues(arr, i, min);
            logger.info(String.format("After Loop %2d %s %n", i, Arrays.toString(arr)));
        }
    }
}

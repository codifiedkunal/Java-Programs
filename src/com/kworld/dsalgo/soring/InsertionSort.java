package com.kworld.dsalgo.soring;

import static com.kworld.util.Util.logger;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        logger.info(String.format("Array Before Soring : %s", Arrays.toString(arr)));
        new InsertionSort().sortArray(arr);
        logger.info(String.format("Array After Soring : %s", Arrays.toString(arr)));
    }

    private void sortArray(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int indexValue = arr[i];
            int j = i;
            while(j > 0 && arr[j-1] > indexValue){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = indexValue;
            logger.info(String.format("Array Loop %2d %s %n", i, Arrays.toString(arr)));
        }
    }
}

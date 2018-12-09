package com.kworld.dsalgo.soring;

import static com.kworld.util.Util.swapValues;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        System.out.println("Array Before Soring : " + Arrays.toString(arr));
        new SelectionSort().sortArray(arr);
        System.out.println("Array After Soring : " + Arrays.toString(arr));
    }

    private void sortArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            swapValues(arr, i, min);
            System.out.printf("After Loop %2d %s \n", i, Arrays.toString(arr));
        }
    }
}

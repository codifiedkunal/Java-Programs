package com.kworld.dsalgo.soring;


import com.kworld.util.Util;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Integer [] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        System.out.println("Array Before Soring : " + Arrays.toString(arr));
        new BubbleSort().sortArray(arr);
        System.out.println("Array After Soring : " + Arrays.toString(arr));
    }

    private void sortArray(Integer [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j])
                    Util.swapValues(arr, j - 1, j);
            }
            System.out.printf("After Loop %2d %s \n", i, Arrays.toString(arr));
        }
    }
}

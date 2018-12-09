package com.kworld.dsalgo.soring;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        System.out.println("Array Before Soring : " + Arrays.toString(arr));
        new InsertionSort().sortArray(arr);
        System.out.println("Array After Soring : " + Arrays.toString(arr));
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
            System.out.printf("Array Loop %2d %s \n", i, Arrays.toString(arr));
        }
    }
}

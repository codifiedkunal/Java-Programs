package com.kworld.dsalgo.soring;

import com.kworld.util.Util;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, 5};

        System.out.println("Array Before Soring : " + Arrays.toString(arr));
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println("Array After Soring : " + Arrays.toString(arr));
    }

    public void quickSort(Comparable[] arr, int leftIdx, int rightIdx) {
        if(leftIdx < rightIdx){
            Comparable pivot = getPivot(arr, leftIdx, rightIdx);
            int i = leftIdx;
            int j = rightIdx;
            while(i <= j){
                while (arr[i].compareTo(pivot) < 0 ) {
                    i++;
                }
                while (arr[j].compareTo(pivot) > 0 ){
                    j--;
                }
                if(i <= j ){
                    Util.swapValues(arr, i, j);
                    i++;
                    j--;
                }
            }
            this.quickSort(arr, leftIdx, j);
            this.quickSort(arr, i, rightIdx);
        }
    }

    private Comparable getPivot(Comparable[] arr, int leftIdx, int rightIdx) {
        return arr[(leftIdx + rightIdx)/2];
    }
}

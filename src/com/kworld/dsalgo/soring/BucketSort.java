package com.kworld.dsalgo.soring;

import java.util.Arrays;

//To Sort Positive Numbers of distinct Values
//If Duplicate Values then it will be removed
public class BucketSort {
    public static void main(String[] args) {
        Integer [] arr = {61, 1, 8, 68, 0, 3, 2, 81, 60, 7, 66, 12, 11};
        System.out.printf("Unsorted Values %s \n", Arrays.toString(arr));
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        Integer sortedArray [] = new Integer[max+1];
        for (int i = 0; i < arr.length; i++) {
            sortedArray[arr[i]] = arr[i];
        }
        for (int i = 0, j= 0; i < sortedArray.length; i++) {
            if(sortedArray[i] != null) {
                arr[j++] = sortedArray[i];
            }
        }
        sortedArray = null;
        System.out.printf("After Sort %s\n", Arrays.toString(arr));
    }
}

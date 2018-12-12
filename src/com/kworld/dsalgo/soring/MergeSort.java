package com.kworld.dsalgo.soring;

import static com.kworld.util.Util.logger;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 8, 6, 0, 3, 2, 8, 6, 7, 66, 12, -1};

        logger.info(String.format("Array Before Soring : %s", Arrays.toString(arr)));
        new MergeSort().sortArray(arr);
        logger.info(String.format("Array After Soring : %s", Arrays.toString(arr)));
    }

    public void sortArray(Comparable[] arr) {
        Comparable temp[] = new Comparable[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(Comparable[] arr, Comparable[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, mid + 1, end);
        }
    }

    private void merge(Comparable[] arr, Comparable[] temp, int start, int startEnd, int endStart, int end) {
        int i, k;
        i = k = start;
        while (start <= startEnd && endStart <= end) {
            if (arr[start].compareTo(arr[endStart]) <= 0)
                temp[i++] = arr[start++];
            else
                temp[i++] = arr[endStart++];
        }
        while (start <= startEnd)
            temp[i++] = arr[start++];
        while (endStart <= end)
            temp[i++] = arr[endStart++];
        for (int j = k; j <= end; j++)
            arr[j] = temp[j];
    }
}

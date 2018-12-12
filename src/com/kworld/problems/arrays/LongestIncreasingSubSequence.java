package com.kworld.problems.arrays;

import static com.kworld.util.Util.logger;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int arr [] = {7, 1, 3, 2, 5, 4, 6};
        logger.info(String.format("Length of Longest Increasing SubSequence using recursive approach is %d", new LongestIncreasingSubSequence().usingRecursive(arr, 0, arr.length, Integer.MIN_VALUE)));
        logger.info(String.format("%nLength of Longest Increasing SubSequence using DP approach is %d", new LongestIncreasingSubSequence().usingDP(arr)));
    }

    private int usingRecursive(int[] arr, int i, int length, int previous) {
        if(i == length)
            return  0 ;
        if(arr[i] <= previous)
            return usingRecursive(arr,  i + 1, length, previous);
        return Math.max(usingRecursive(arr,  i + 1, length, previous),
                1 + usingRecursive(arr,  i + 1, length, arr[i]));
    }

    //Construct & print longest increasing subsequence
    private int usingDP(int[] arr) {
        List<Integer> lis [] = new ArrayList[arr.length];
        lis[0] = new ArrayList<>(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            lis[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]
                        && lis[i].size() < lis[j].size())
                    lis[i].add(arr[j]);
            }
            lis[i].add(arr[i]);
        }

        List<Integer> max = lis[0];
        for (int i = 1; i < lis.length; i++) {
            if(lis[i].size() > max.size())
                max = lis[i];
        }

        logger.info("\nLongest incresing sub seqence is " + max);
        return max.size();
    }
}
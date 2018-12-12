package com.kworld.problems.arrays;

import static com.kworld.util.Util.logger;

public class RemoveDuplicate0to10 {
    public static void main(String[] args) {
        int [] arr = {0 ,3, 4, 5, 3, 0, 9, 3, 1, 10, 4};

        boolean [] set = new boolean [arr.length];

        int len = 0;
        for (int i = 0;i< arr.length; i++){
            if(!set[arr[i]]){
                set[arr[i]] = true;
                len++;
            }
        }

        int [] newArr = new int [len];
        for (int i = 0, j = 0;i< arr.length; i++){
            if(set[i]){
                newArr[j] = i;
                j++;
            }
        }

        for (int i = 0, j = 0;i< newArr.length; i++){
        	logger.info(newArr[i] + " ");
        }
    }
}

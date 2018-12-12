package com.kworld.problems.arrays;

import static com.kworld.util.Util.logger;

// 0/1 Knapsack
public class KnapsackProblem {
    public static void main(String[] args) {
    	//logger.info("Enter Capacity of Knapsack :");
        int capacity = 4;//Util.scanner.nextInt();
        //System.out.print("Enter No of Items :");
        int noOfItems = 5;//Util.scanner.nextInt();

        int weight[] = {1,2,3,2,2};//new int[noOfItems];
        int value[] = {8,4,0,4,3};//new int[noOfItems];
        /*for (int i = 0; i < noOfItems; i++) {
            System.out.print(String.format("Enter %dth Items Weight :", (i+1)));
            weight[i] = Util.scanner.nextInt();
            System.out.print(String.format("Enter %dth Items Value :", (i+1)));
            value[i] = Util.scanner.nextInt();
        }
        logger.info(("\nItems are :");
        for (int i = 0; i < noOfItems; i++) {
            System.out.println("(" + weight[i] + " , " + value[i] + " )");
        }*/

        logger.info(String.format("Knapsack Value %d ", solveKnapsackRecursive(weight, value, noOfItems, capacity)));
        logger.info(String.format("%nKnapsack Value using DP %d ", solveKnapsackDP(weight, value, noOfItems, capacity)));
    }

    private static int solveKnapsackDP(int[] weight, int[] value, int noOfItems, int capacity) {
        //All Value defaulted to 0
        int knapsack [][] = new  int [noOfItems+1][capacity+1];

        for (int i = 1; i <= noOfItems; i++) {
            for (int j = 1; j <=capacity ; j++) {
                if(weight[i-1]>j)
                    knapsack[i][j] = knapsack[i-1][j];
                else {
                    // maximum of once including the current item and once not including
                    knapsack[i][j] = Math.max(value[i - 1] + knapsack[i - 1][j - weight[i - 1]],
                            knapsack[i - 1][j]);
                }
            }
        }

        return knapsack[noOfItems][capacity];
    }

    private static void print(int[][] memorize) {
        for (int i = 0; i < memorize.length; i++) {
            int [] arr = memorize[i];
            for (int j = 0; j < arr.length; j++) {
            	logger.info(memorize[i][j] + ",");
            }
            logger.info("\n");
        }
        logger.info("----------");
    }

    private static int solveKnapsackRecursive(int[] weight, int[] value, int noOfItems, int capacity) {
        if(capacity <=0 || noOfItems <=0)
            return 0;

        //Current Item can't be included
        if(weight[noOfItems-1]>capacity)
            return solveKnapsackRecursive(weight, value, noOfItems-1, capacity);

        //max between solution including current item and withoud current item
        return Math.max(value[noOfItems-1] + solveKnapsackRecursive(weight, value, noOfItems-1, capacity - weight[noOfItems-1]),
                solveKnapsackRecursive(weight, value, noOfItems-1, capacity));
    }
}

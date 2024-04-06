package com.sudipcold.dynamic.boundedknapsack;

import java.util.Arrays;

public class Knapsack {
    public static int findKnapsackBruteForce(int capacity, int[] weights, int[] values, int n) {
        if(n == 0 || capacity == 0){
            return 0;
        }

        if(weights[n-1] <= capacity){
            return Math.max(values[n-1] + findKnapsackBruteForce(capacity - weights[n-1], weights, values, n-1),
                    findKnapsackBruteForce(capacity, weights, values, n - 1));
        }else {
            return findKnapsackBruteForce(capacity, weights, values, n - 1);
        }
    }

    public static int findKnapsackRecTopDown(int capacity, int[] weights, int[] values, int n, int[][] dp) {
        // Base case
        if (n == 0 || capacity == 0)
            return 0;

        // If we have solved it earlier, then return the result from memory
        if (dp[n][capacity] != -1)
            return dp[n][capacity];

        // Otherwise, we solve it for the new combination and save the results in the memory
        if (weights[n - 1] <= capacity) {
            dp[n][capacity] = Math.max(
                    values[n - 1] + findKnapsackRecTopDown(capacity - weights[n - 1], weights, values, n - 1, dp),
                    findKnapsackRecTopDown(capacity, weights, values, n - 1, dp)
            );
            return dp[n][capacity];
        }
        dp[n][capacity] = findKnapsackRecTopDown(capacity, weights, values, n - 1, dp);
        return dp[n][capacity];
    }

    public static int findKnapsackTopDown(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return findKnapsackRecTopDown(capacity, weights, values, n, dp);
    }

    public static int findKnapsackBottomUp(int capacity, int[] weights, int[] values, int n) {
        // create a table to hold intermediate values
        int[][] dp = new int[n + 1][capacity + 1];
        for(int[] row: dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                // initialize the table with 0 when either the row or column is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                    // check if the weight of an item is less than the capacity
                else if (weights[i - 1] <= j)
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);

                    // we don't include the item if the weight is greater than the capacity.
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3,1,2,4};
        int[] values = new int[]{3,5,2,7};
        System.out.println(findKnapsackBruteForce(5, weights, values, 4));
    }
}

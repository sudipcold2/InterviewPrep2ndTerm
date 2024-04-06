package com.sudipcold.dynamic.boundedknapsack;

import java.util.Arrays;

public class TargetSum {

    public static int targetSumHelper(int[] arr, int i, int T){
        if(i == arr.length){
            if(T == 0)
                return 1;
            return 0;
        }

        return (targetSumHelper(arr, i+1, T + arr[i]) + targetSumHelper(arr, i+1, T - arr[i]));
    }

    public static int targetSumBruteForce(int[] arr, int T){
        return targetSumHelper(arr, 0, T);
    }

    public static int findTargetSumWaysRec(int[] arr, int T, int total, int i, int sum, int[][] dp){
        // If all integers are processed
        if (i == arr.length){
            // If target is reached
            if (sum == T)
                return 1;
            // If target is not reached
            return 0;
        }

        // If we have solved it earlier, then return the result from memory
        if (dp[i][sum + total] != -1)
            return dp[i][sum + total];

        // Calculate both sub-problems and save the results in the memory
        dp[i][sum + total] = findTargetSumWaysRec(arr, T, total, i + 1, sum - arr[i], dp) +
                findTargetSumWaysRec(arr, T, total, i + 1, sum + arr[i], dp);

        return dp[i][sum + total];
    }

    public static int findTargetSumWaysTopDown(int[] arr, int T){
        int total = 0;
        for (int num : arr)
            total+=num;

        // If the target can't be generated using the given numbers
        if (total < Math.abs(T))
            return 0;

        // Initialize a lookup table
        int[][] dp = new int[arr.length][2*total+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);

        return findTargetSumWaysRec(arr, T, total, 0, 0, dp);
    }

    public static int findTargetSumWaysBottomUp(int[] arr, int T){
        int total = 0;
        for (int num : arr)
            total+=num;

        // If the target can't be generated using the given numbers
        if (total < Math.abs(T))
            return 0;

        // Initialize a lookup table
        int[][] dp = new int[arr.length][2*total+1];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        dp[0][total + arr[0]] = 1;
        dp[0][total - arr[0]] += 1;

        // For every integer
        for (int i=1; i<arr.length; ++i)
            // For every possible target sum
            for (int t=-total; t<total+1; ++t)
                // If at least one expression (during previous iterations) evaluated to this target sum
                if (dp[i - 1][total + t] > 0){
                    dp[i][total + t + arr[i]] += dp[i - 1][total + t];
                    dp[i][total + t - arr[i]] += dp[i - 1][total + t];
                }

        return dp[arr.length-1][T+total];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int i = targetSumBruteForce(arr, 0);
        System.out.println(i);
    }
}

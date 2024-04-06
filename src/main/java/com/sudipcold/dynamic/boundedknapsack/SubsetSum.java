package com.sudipcold.dynamic.boundedknapsack;

import java.util.Arrays;


/**
 * Given a set of positive numbers arr and a value total, determine if there exists
 * a subset in the given set whose sum is equal to total. A subset can be an empty set,
 * or it can either consist of some elements of the set or all the elements of the set.
 *
 * Let’s say you are given a set = {1, 2, 3, 7} and a total = 6.
 * The output will be TRUE as the subset = {1, 2, 3} adds up to make the desired total (1+2+3) = 6.
 */
public class SubsetSum {


    public static boolean subsetSumHelper(int[] arr, int n, int target){
        if(target == 0)
            return true;
        if(n == 0)
            return false;

        // if last element is greater than total we ignore it
        if(arr[n -1] > target)
            return subsetSumHelper(arr, n - 1, target);

        // We either exclude the element or include the element
        return subsetSumHelper(arr, n-1, target) || subsetSumHelper(arr, n-1, target - arr[n-1]);
    }

    public static boolean subsetSum(int[] arr, int target){
        return subsetSumHelper(arr, arr.length, target);
    }

    public static boolean subsetSumTopDown(int[] arr, int target){
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for(int[] dpRow : dp){
            Arrays.fill(dpRow, -1);
        }

        return subsetSumDpHelperTopDown(arr, n-1, target, dp) == 1;
    }

    private static int subsetSumDpHelperTopDown(int[] arr, int n, int target, int[][] dp) {
        if(target == 0)
            return 1;

        if(n == 0)
            return 0;

        if (dp[n][target] != -1)
            return dp[n][target];

        if(arr[n-1] > target){
            dp[n][target] = subsetSumDpHelperTopDown(arr, n-1, target, dp);
            return dp[n][target];
        }

        dp[n][target] = subsetSumDpHelperTopDown(arr, n-1, target, dp) |
                subsetSumDpHelperTopDown(arr, n-1, target - arr[n-1], dp);
        return dp[n][target];

    }

    public static boolean subsetSumBottomUp(int [] arr, int total) {
        // intializing array of size (n+1) x (total+1)
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][total+1];

        // filling the array with 0 (false)
        for(int i = 0; i < n+1; i++)
            for(int j = 0; j < total+1; j++)
                dp[i][j] = false;

        // Base cases
        for (int k = 0; k< n; k++)
            for (int l = 0; l< total; l++){
                if (k == 0){
                    dp[k][l] = false;
                }
                if (l == 0){
                    dp[k][l] = true;
                }
            }

        // iterating throuh whole array to get subset sum
        for (int i = 1; i< n+1; i++)
            for (int j = 0; j< total+1; j++){

                // ignore element if its greater than total
                if (arr[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }

                // otherwise we proceed to rest of the elements
                else{
                    dp[i][j] = dp[i-1][j-arr[i-1]];
                }
            }
        return dp[n][total];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(subsetSum(arr, 6));
        System.out.println(subsetSumTopDown(arr, 6));
    }
}

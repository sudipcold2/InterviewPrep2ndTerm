package com.sudipcold.dynamic.boundedknapsack;

import java.util.Arrays;

/**
 * Given a set of positive numbers nums and a value targetSum, count the total number
 * of subsets of the given set whose sum is equal to the targetSum.
 *
 */
public class CountSubsetSum {

    private static long getCountSubsetSumHelper(int[] arr, int index, int target){
        if(target == 0)
            return 1;
        if(index == arr.length)
            return 0;

        //include arr[index] if smaller than target
        long sum1 = 0;
        if(arr[index] <= target){
            sum1 = getCountSubsetSumHelper(arr, index + 1, target - arr[index]);
        }

        //exclude it and just move
        long sum2 = getCountSubsetSumHelper(arr, index + 1, target);

        return sum1 + sum2;
    }

    public static long getCountSubsetSum(int[] arr, int target){
        return getCountSubsetSumHelper(arr, 0 , target);
    }

    public static long getCountSubsetSumTopDown(int[] arr, int target){
        int n = arr.length;
        long [][] dp = new long[n+1][target+1];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }

        return getCountSubsetSumTopDownHelper(arr, 0, target, dp);
    }

    private static long getCountSubsetSumTopDownHelper(int[] arr, int i, int target, long[][] dp) {
        if(target == 0)
            return 1;
        if(i == arr.length)
            return 0;

        if(dp[i][target] == -1){
            long sum1 = 0;
            if(arr[i] <= target){
                sum1 = getCountSubsetSumTopDownHelper(arr, i + 1, target - arr[i], dp);
            }
            long sum2 = getCountSubsetSumTopDownHelper(arr, i + 1, target, dp);
            dp[i][target] = sum1 + sum2;
        }
        return dp[i][target];
    }

    public static long getSubsetCountBottomUp(int nums[], int targetSum){
        int len = nums.length;
        int dp[][] = new int[len][targetSum+1];
        for(int[] a : dp){
            Arrays.fill(a, 0);
        }

        if(nums[0] == 0)
            dp[0][0] = 0;
        else {
            dp[0][0] = 1;
            if (nums[0] <= targetSum)
                dp[0][nums[0]] = 1;
        }

        for(int i = 1; i < len; i++){
            for(int r = 0; r <= targetSum; r++){
                int sum1 = 0;
                if(nums[i] <= r){
                    sum1 = dp[i-1][r-nums[i]];
                }
                int sum2 = dp[i-1][r];
                dp[i][r] = sum1 + sum2;
            }
        }

        return dp[len-1][targetSum];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(getCountSubsetSum(arr, 4));
        System.out.println(getCountSubsetSumTopDown(arr, 4));
        System.out.println(getSubsetCountBottomUp(arr, 4));
    }

}

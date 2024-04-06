package com.sudipcold.dynamic.boundedknapsack;

import java.util.Arrays;

public class PartitionArrayToMinimiseDifferenceInSum {

    private static int getMinDiffHelper(int[] arr, int index, int sum1, int sum2){
        if(index == arr.length)
            return Math.abs(sum1 - sum2);

        return Math.min(getMinDiffHelper(arr, index + 1, sum1 + arr[index], sum2),
                getMinDiffHelper(arr, index + 1, sum1, sum2 + arr[index]));
    }

    public static int getMinDiff(int[] arr){
        return getMinDiffHelper(arr, 0, 0, 0);
    }

    public static int getMinDiffTopDown(int[] arr){
        int row = arr.length;
        int col = 0;
        for(int a : arr)
            col+=a;
        col = col+1;
        int[][] dp = new int[row][col];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return getMinDiffHelperTopDown(arr, 0, 0, 0, dp);
    }

    private static int getMinDiffHelperTopDown(int[] arr, int i, int s1, int s2, int[][] dp) {
        if(i == arr.length)
            return Math.abs(s1-s2);

        dp[i][s1] = Math.min(getMinDiffHelperTopDown(arr, i+1, s1 + arr[i], s2, dp),
                getMinDiffHelperTopDown(arr, i + 1, s1, s2 + arr[i], dp));

        return dp[i][s1];
    }

    public static int minimumPartitionArraySumDifference(int[] nums){

        // Calculating the sum of the original array
        int sumArray = 0;

        for(int i = 0; i < nums.length; i++){
            sumArray = sumArray + nums[i];
        }

        // Calculating the number of rows and columns in the 2-D array
        int rows = nums.length;
        int cols = (int) (Math.floor(sumArray / 2) + 1);

        int[][] dp = new int[rows][cols];

        // Initializing the 2-D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        // The first column will be initialized to all 1s, since a sum s = 0
        // will always be true if no elements are added to the subset
        for (int i = 0; i < rows; i++){
            dp[i][0] = 1;
        }

        // For the first row, each entry will be 1 if the sum s is equal to the
        // first element, and 0 otherwise
        for (int s = 1; s < cols; s++){
            int element = (nums[0] == s) ? 1 : 0;
            dp[0][s] = element;
        }

        // Iterating and filling the dp array
        for (int i = 1; i < rows; i++){
            for (int s = 1; s < cols; s++){
                // Check if sum s can be obtained without nums[i] in the array
                if (dp[i - 1][s] == 1)
                    dp[i][s] = dp[i - 1][s];

                    // Check if sum s can be obtained with nums[i] in the array
                else if (s >= nums[i])
                    dp[i][s] = dp[i - 1][s - nums[i]];

                    // If neither of the above two conditions is true, sum s can not be
                    // obtained with nums[i] included in the array
                else
                    dp[i][s] = 0;
            }
        }

        // Find the largest index in the last row which is 1 and return the absolute
        // difference between the two sums
        int result = 0;
        for (int s = cols - 1; s >= 0; s--){
            if (dp[rows - 1][s] == 1){
                int sum1 = s;
                int sum2 = sumArray - sum1;
                result = Math.abs(sum2 - sum1);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {11,2,3,4};
        System.out.println(getMinDiff(arr));
        System.out.println(getMinDiffTopDown(arr));
        System.out.println(minimumPartitionArraySumDifference(arr));
    }
}

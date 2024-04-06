package com.sudipcold.slidingwindow;

/**
 * Given an array where the element at the index i represents the price of a stock on day i,
 * find the maximum profit that you can gain by buying the stock once and then selling it.
 */
public class BestTimeToBuyAndSellStock {

    public static int getMaxProfit(int arr[]){
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        int currentProfit = 0;
        while(sell < arr.length){
            currentProfit = arr[sell] - arr[buy];
            if(arr[sell] > arr[buy]){
                maxProfit = Math.max(currentProfit, maxProfit);
            }else{
                buy = sell;
            }
            sell++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        System.out.println(getMaxProfit(arr));
    }
}

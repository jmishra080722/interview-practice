package org.example.leetcode150;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and
choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellShare {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int calculateMaxProfit(int[] prices) {
        int len = prices.length;
        int count = 0;
        int maxProfit = 0;
        while(count < len-1 ){
            for(int i = count+1; i< len; i++){
                int profit = prices[i] - prices[count];
                if(profit > 0){
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
            count++;
        }
        return maxProfit;
    }

    private static int maxProfit(int[] prices){
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else if(prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

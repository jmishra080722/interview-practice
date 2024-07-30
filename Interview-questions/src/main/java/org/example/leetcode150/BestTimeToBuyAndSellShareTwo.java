package org.example.leetcode150;

/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.*/
public class BestTimeToBuyAndSellShareTwo {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfitTwo(prices);
        System.out.println(maxProfit);
    }

    private static int maxProfitTwo(int[] prices) {
        int buy = prices[0];
        int profit= 0;
        for(int i=0; i<prices.length; i++){
            if(buy < prices[i]){
                profit += prices[i] - buy;
            }
            buy= prices[i];
        }
        return profit;
    }
}

package org.example.leetcode150;

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

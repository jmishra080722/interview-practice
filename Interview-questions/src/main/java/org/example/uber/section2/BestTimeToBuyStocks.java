package org.example.uber.section2;

public class BestTimeToBuyStocks {

    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i< prices.length; i++){
            if(buy < prices[i]){
                profit = Math.max(profit, prices[i] - buy);
            }else {
                buy = prices[i];
            }
        }
        System.out.println("Profit : "+profit);
    }
}

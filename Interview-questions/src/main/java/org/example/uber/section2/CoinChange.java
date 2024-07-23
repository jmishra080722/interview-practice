package org.example.uber.section2;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a
total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 9};
        int amount = 11;
        int numOfCoins = minNumOfCoin(coins, amount);
        System.out.println(numOfCoins);
    }

    private static int minNumOfCoin(int[] coins, int amount) {
        if(amount < 0){
            return -1;
        }
        int[] minCoinDP = new int[amount +1];
        for(int i = 1; i <= amount; i++){
            minCoinDP[i] = Integer.MAX_VALUE;

            for(int coin: coins){
                if(coin <= i && minCoinDP[i - coin] != Integer.MAX_VALUE){
                    minCoinDP[i] = Math.min(minCoinDP[i], 1 + minCoinDP[i - coin]);
                }
            }
        }
        return minCoinDP[amount] == Integer.MAX_VALUE ? -1 : minCoinDP[amount];
    }
}

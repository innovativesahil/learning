package com.sahil.learning.algo;

/*
* You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
* On each day, you may decide to buy and/or sell the stock.
* You can only hold at most one share of the stock at any time.
* However, you can buy it then immediately sell it on the same day.
*
* Find and return the maximum profit you can achieve.
* */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int start = prices[0];
        int max = 0;

        for(int i = 0; i < prices.length; i++){

            if(start < prices[i]){
                max += prices[i] - start;
            }
            start = prices[i];
        }
        return max;
    }
}

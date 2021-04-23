package com.leetcode.practice.solutions;

public class SolutionOffer53 {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            int max = maxProfit(prices, i + 1, prices[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    public int maxProfit(int[] prices, int start, int buyPrice) {
        int max = 0;
        for (int i = start; i < prices.length; i ++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

}

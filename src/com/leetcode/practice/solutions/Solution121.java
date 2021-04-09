package com.leetcode.practice.solutions;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            if (lowPrice > price) {
                lowPrice = price;
            } else if (price - lowPrice > profit) {
                profit = price - lowPrice;
            }
        }
        return profit;
    }
}

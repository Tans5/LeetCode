package com.leetcode.practice.solutions;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        Integer buyIndex = null;
        int size = prices.length;
        for (int i = 0; i < size; i ++) {
            if (buyIndex != null) {
                max += prices[i] - prices[buyIndex];
                buyIndex = null;
            }
            if (i + 1 < size) {
                int value1 = prices[i];
                int value2 = prices[i + 1];
                if (value2 > value1) {
                    buyIndex = i;
                }
            }
        }
        return max;
    }
}

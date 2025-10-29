package com.leetcode.practice.solutions;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i ++) {
            int a = prices[i - 1];
            int b = prices[i];
            if (b > a) {
                max += b - a;
            }
        }
        return max;
    }
}

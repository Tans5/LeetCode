package com.leetcode.practice.solutions;

public class Solution309 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        /**
         * 当天持有股票的三种状态
         * 0: 持有股票
         * 1: 不持有股票，禁止买入
         * 2: 不持有股票，不禁止买入
         */
        int [][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i ++) {
            // 取上一次持有股票的收入与当前买入的股票后的较大值，作为当前持有股票的最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 将上次持有的股票在本轮卖出
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}

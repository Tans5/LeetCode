package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 *
 * 输入: prices = [1]
 * 输出: 0
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 每天股票买卖的三种状态：
        // 0: 持有股票时的最大利润
        // 1: 不持有股票时的最大利润，允许明天买入
        // 2: 不持有股票时的最大利润，不允许明天买入
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i ++) {
            // 当天持有股票的最大利润是：前一天持有股票的最大利润和今天买入时的利润中的较大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);

            // 不持有股票
            // 允许明天买入: 前一天不允许买入和允许买入时的利润较大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            // 不允许明天买入：卖出持有的股票
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}

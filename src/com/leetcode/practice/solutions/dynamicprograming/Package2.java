package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 0-1 背包问题
 * 给定 n 个物品，第 i 个物品的重量为 weight[i - 1] 价值为 value[i - 1]，和一个容量为 cap 的背包。每个物品可以重复选择，问在限定背包容量下能放入物品的最大价值。
 *
 *
 */
public class Package2 {

    public int maxValue(int[] weight, int[] value, int cap) {
        if (cap <= 0) {
            return 0;
        }
        if (value.length != weight.length) {
            return 0;
        }
        // 到第 i 个物品为止，容量为 j 的背包的最大价值
        int[][] dp = new int[weight.length + 1][cap + 1];
        for (int i = 1; i <= weight.length; i ++) {
            int w = weight[i - 1];
            int v = value[i - 1];
            // 由于物品可以重复选择，所以必须从小到大遍历 （注意和 0-1 背包问题的区别）
            for (int c = 1; c <= cap; c ++) {
                if (c < w) {
                    // 容量小于当前物品重量，所以无法选择
                    dp[i][c] = dp[i - 1][c];
                } else {
                    // 选择当前物品，或者不选择当前物品
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i][c - w] + v);
                }
            }
        }
        return dp[weight.length][cap];
    }


    /**
     * 空间优化版
     */
    public int maxValue2(int[] weight, int[] value, int cap) {
        if (cap <= 0) {
            return 0;
        }
        if (value.length != weight.length) {
            return 0;
        }
        // 容量为 i 时，最大的价值
        int[] dp = new int[cap + 1];
        for (int i = 1; i <= weight.length; i ++) {
            int w = weight[i - 1];
            int v = value[i - 1];
            // 从小往大遍历，因为可以重复使用物品
            for (int c = w; c <= cap; c ++) {
                dp[c] = Math.max(dp[c], dp[c - w] + v);
            }
        }
        return dp[value.length];
    }
}

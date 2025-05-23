package com.leetcode.practice.solutions.dynamicprograming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int a = 0; a <= amount; a ++) {
            if (a % coins[0] == 0) {
                // 可以放入
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = -1;
            }
        }

        for (int i = 1; i < coins.length; i ++) {
            int coin = coins[i];
            for (int a = 1; a <= amount; a++) {
                if (a < coin) {
                    // 无法放入 i 的硬币
                    dp[i][a] = dp[i - 1][a];
                } else {
                    // 可以选择放入 i 的硬币或者不放入
                    // 不放入
                    int t1 = dp[i - 1][a];
                    // 放入
                    int t2 = dp[i][a - coin];
                    if (t2 != -1) {
                        t2 ++;
                    }
                    if (t1 != -1 && t2 != -1) {
                        dp[i][a] = Math.min(t1, t2);
                    } else if (t1 != -1) {
                        dp[i][a] = t1;
                    } else {
                        dp[i][a] = t2;
                    }
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}

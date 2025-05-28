package com.leetcode.practice.solutions.dynamicprograming;


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
        // 如果到 i 对应的硬币，兑换 j 对应的 amount，最小有多少兑换方式
        int[][] dp = new int[coins.length + 1][amount + 1];

        // 如果 amount 等于 0，则所有选择硬币的兑换方式都是 0
        for (int i = 1; i <= coins.length; i ++) {
            dp[i][0] = 0;
        }

        // 如果不选硬币，则所有的 amount 兑换的方式都是 -1，也就是无法兑换。
        for (int a = 1; a <= amount; a ++ ) {
            dp[0][a] = -1;
            // 初始化 a 能够兑换多少 coin[0]
            if (a % coins[0] == 0) {
                // 可以兑换
                dp[1][a] = a / coins[0];
            } else {
                // 无法兑换
                dp[1][a] = -1;
            }
        }

        for (int i = 2; i <= coins.length; i ++) {
            int coin = coins[i - 1];
            for (int a = 1; a <= amount; a ++) {
                if (coin > a) {
                    // 无法选择 coin 兑换成 a
                    dp[i][a] = dp[i - 1][a];
                } else {
                    // 不选择 coin
                    int t1 = dp[i - 1][a];
                    // 选择 coin
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

        return dp[coins.length][amount];
    }
}

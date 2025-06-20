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
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int cap = coin; cap <= amount; cap++) {
                if (dp[cap] == -1 && dp[cap - coin] == -1) {
                    dp[cap] = -1;
                } else if (dp[cap] == -1) {
                    dp[cap] = dp[cap - coin] + 1;
                } else if (dp[cap - coin] == -1) {
                    dp[cap] = dp[cap];
                } else {
                    dp[cap] = Math.min(dp[cap], dp[cap - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}

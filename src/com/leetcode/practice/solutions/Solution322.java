package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i ++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                } else {
                    int sub = i - coin;
                    if (dp[sub] != -1) {
                        min = Math.min(dp[sub], min);
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}

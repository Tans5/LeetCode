package com.leetcode.practice.solutions.dynamicprograming;

import java.util.Arrays;

public class Solution322_2 {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        // 硬币兑换成 i 最少的兑换次数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin: coins) {
            // 可以重复兑换，所以要从小往大排
            for (int a = coin; a <= amount; a ++) {
                dp[a] = Math.min(dp[a], dp[a - coin] + 1);
            }
        }
        int result = dp[amount];
        if (result < (amount + 1)) {
            return result;
        } else {
            return -1;
        }
    }
}

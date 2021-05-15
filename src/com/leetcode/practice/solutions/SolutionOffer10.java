package com.leetcode.practice.solutions;

public class SolutionOffer10 {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return n;
        } else {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i ++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % (int)(1E9 + 7);
            }
            return dp[n - 1];
        }
    }

}

package com.leetcode.practice.solutions;

public class Solution64 {
    public static int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}

package com.leetcode.practice.solutions;

public class SolutionOffer47 {
    public int maxValue(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int[][] dp = new int[height][width];
        for (int h = 0; h < height; h ++) {
            for (int w = 0; w < width; w ++) {
                if (h == 0) {
                    if (w == 0) {
                        dp[h][w] = grid[h][w];
                    } else {
                        dp[h][w] = grid[h][w] + dp[h][w - 1];
                    }
                } else {
                    if (w == 0) {
                        dp[h][w] = grid[h][w] + dp[h - 1][w];
                    } else {
                        dp[h][w] = Math.max(grid[h][w] + dp[h - 1][w], grid[h][w] + dp[h][w - 1]);
                    }
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}

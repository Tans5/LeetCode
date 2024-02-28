package com.leetcode.practice.solutions;

public class Solution200 {

    public int numIslands(char[][] grid) {
        int landCount = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[r].length; c ++) {
                if (grid[r][c] == '1') {
                    landCount ++;
                    clearLand(grid, r, c);
                }
            }
        }
        return landCount;
    }

    void clearLand(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length) {
            return;
        }
        if (c < 0 || c >= grid[r].length) {
            return;
        }
        if (grid[r][c] == '1') {
            grid[r][c] = '0';
            clearLand(grid, r - 1, c);
            clearLand(grid, r, c - 1);
            clearLand(grid, r + 1, c);
            clearLand(grid, r, c + 1);
        }
    }
}

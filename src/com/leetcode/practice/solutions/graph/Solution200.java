package com.leetcode.practice.solutions.graph;


/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == '1') {
                    count ++;
                    cleanOne(row, col, grid);
                }
            }
        }

        return count;
    }

    private void cleanOne(int row, int col, char[][] grid) {
        int rowSize = grid.length;
        if (row < 0 || row >= rowSize) {
            return;
        }
        int colSize = grid[0].length;
        if (col < 0 || col >= colSize) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        int[] next = new int[] {
                row - 1, col, // 上
                row + 1, col, // 下
                row, col - 1, // 左
                row, col + 1, // 右
        };
        for (int i = 0; i < next.length / 2; i ++) {
            int r = next[i * 2];
            int c = next[i * 2 + 1];
            cleanOne(r, c, grid);
        }
    }
}

package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Solution221 {

    public int maximalSquare(char[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int maxSquareWidth = 0;
        // 以 (i - 1, j - 1) 为右下角点的正方形的最大的边长
        int[][] dp = new int[rowSize + 1][ colSize + 1];
        for (int row = 0; row < rowSize; row ++) {
            for (int col = 0; col < colSize; col ++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(
                            Math.min(dp[row][col + 1], dp[row + 1][col]),
                            dp[row][col]
                    ) + 1;
                    if (dp[row + 1][col + 1] > maxSquareWidth) {
                        maxSquareWidth = dp[row + 1][col + 1];
                    }
                }
            }
        }
        return maxSquareWidth * maxSquareWidth;
    }
}

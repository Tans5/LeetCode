package com.leetcode.practice.solutions.backtracking;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class Solution329 {

    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        // 因为题目要求是严格递增的数组，不可以取等，所以不用考虑环和重复使用值。
        int[][] history = new int[rowSize][colSize];
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                int len = maxLength(matrix, row, col, history);
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    private int maxLength(int[][] matrix, int row, int col, int[][] history) {
        int rowSize = matrix.length;
        if (row >= rowSize || row < 0) {
            return 0;
        }
        int colSize = matrix[0].length;
        if (col >= colSize || col < 0) {
            return 0;
        }
        if (history[row][col] != 0) {
            return history[row][col];
        }
        int num = matrix[row][col];
        int[] next = new int[] {
            row - 1, col, // 上
            row + 1, col, // 下
            row, col - 1, // 左
            row, col + 1, // 右
        };
        int maxLen = 1;
        for (int i = 0; i < next.length / 2; i ++) {
            int r = next[i * 2];
            int c = next[i * 2 + 1];
            if (r >= 0 && r < rowSize && c >= 0 && c < colSize && matrix[r][c] > num) {
                int len = maxLength(matrix, r, c, history) + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        history[row][col] = maxLen;
        return maxLen;
    }
}

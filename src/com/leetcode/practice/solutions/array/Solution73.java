package com.leetcode.practice.solutions.array;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class Solution73 {

    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        if (rowSize == 0) {
            return;
        }
        int colSize = matrix[0].length;
        if (colSize == 0) {
            return;
        }
        int[][] copy = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row ++) {
            System.arraycopy(matrix[row], 0, copy[row], 0, colSize);
        }
        for (int row = 0; row < rowSize; row ++) {
            for (int col = 0; col < colSize; col ++) {
                if (copy[row][col] == 0) {
                    Arrays.fill(matrix[row], 0);
                    for (int r = 0; r < rowSize; r ++) {
                        matrix[r][col] = 0;
                    }
                }
            }
        }
    }
}

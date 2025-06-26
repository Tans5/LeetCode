package com.leetcode.practice.solutions.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> toCleanRow = new HashSet<>();
        Set<Integer> toCleanCol = new HashSet<>();
        for (int row = 0; row < rowSize; row ++) {
            for (int col = 0; col < colSize; col ++) {
                if (matrix[row][col] == 0) {
                    toCleanRow.add(row);
                    toCleanCol.add(col);
                }
            }
        }
        for (int row: toCleanRow) {
            Arrays.fill(matrix[row], 0);
        }
        for (int col: toCleanCol) {
            for (int row = 0; row < rowSize; row ++) {
                matrix[row][col] = 0;
            }
        }
    }
}

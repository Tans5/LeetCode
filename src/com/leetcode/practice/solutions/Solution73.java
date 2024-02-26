package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution73 {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        if (matrix[0].length == 0) {
            return;
        }
        int [][] originMatrix = new int[matrix.length][0];
        for (int i = 0; i < matrix.length; i ++) {
            originMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        for (int row = 0; row < originMatrix.length; row ++) {
            for (int col = 0; col < originMatrix[row].length; col ++) {
                if (originMatrix[row][col] == 0) {
                    cleanCol(col, matrix);
                    cleanRow(row, matrix);
                }
            }
        }
    }

    void cleanRow(int rowIndex, int[][] matrix) {
        int[] row = matrix[rowIndex];
        Arrays.fill(row, 0);
    }

    void cleanCol(int colIndex, int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            matrix[i][colIndex] = 0;
        }
    }
}

package com.leetcode.practice.solutions;

public class Solution48 {

    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] oldMatrix = new int[size][size];
        for (int i = 0; i < size; i ++) {
            System.arraycopy(matrix[i], 0, oldMatrix[i], 0, size);
        }
        float center = size / 2f;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                int x0 = Math.round(2 * center - i) - 1;
                matrix[j][x0] = oldMatrix[i][j];
            }
        }
    }

}

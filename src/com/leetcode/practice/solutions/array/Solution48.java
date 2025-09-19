package com.leetcode.practice.solutions.array;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 7 4 1
 * 8 5 2
 * 9 6 3
 *
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *
 * 13 9  5  1
 * 14 10 6  2
 * 15 11 7  3
 * 16 12 8  4
 */
public class Solution48 {


    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        // 先将行转换成列
        for (int row = 0; row < matrix.length; row ++) {
            // 注意 col 开始的值是 row.
            for (int col = row; col < matrix.length; col ++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // 将每行再首尾交换
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix.length / 2; col ++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length - col - 1];
                matrix[row][matrix.length - col - 1] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        float center;
        if (n % 2 == 0) {
            center = (n - 1) / 2.0f;
        } else {
            center =  n / 2;
        }
        for(int row = 0; row <= center; row ++) {
            for (int col = 0; col <= center; col ++) {
                float x1;
                float y1;
                float x2;
                float y2;
                float x3;
                float y3;
                float x4;
                float y4;
                if (row == fixIndex(center)) {
                    x1 = col;
                    y1 = row;
                    x2 = y1;
                    y2 = x1;
                    x3 = (center - x1) + center;
                    y3 = center;
                    x4 = x2;
                    y4 = center + (center - y2);
                } else if (col == fixIndex(center)) {
                    // Skip
                    continue;
                } else {
                    x1 = col;
                    y1 = row;
                    x2 = center + (center - y1);
                    y2 = center - (center - x1);
                    x3 = center + (center - x1);
                    y3 = center + (center - y1);
                    x4 = center - (x2 - center);
                    y4 = center + (center - y2);
                }
                int temp = matrix[fixIndex(y4)][fixIndex(x4)];
                matrix[fixIndex(y4)][fixIndex(x4)] = matrix[fixIndex(y3)][fixIndex(x3)];
                matrix[fixIndex(y3)][fixIndex(x3)] = matrix[fixIndex(y2)][fixIndex(x2)];
                matrix[fixIndex(y2)][fixIndex(x2)] = matrix[fixIndex(y1)][fixIndex(x1)];
                matrix[fixIndex(y1)][fixIndex(x1)] = temp;
            }
        }
    }

    private int fixIndex(float a) {
        return (int) (a + 0.5f);
    }
}

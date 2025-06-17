package com.leetcode.practice.solutions.array;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        if (rowSize == 0) {
            return false;
        }
        int colSize = matrix[0].length;
        if (colSize == 0) {
            return false;
        }
        // 从右上角开始搜索，右上角的值小于目标值向下移动，如果大于目标值向左移动
        int r = 0;
        int c = colSize - 1;
        while (r < rowSize && c >= 0) {
            int n = matrix[r][c];
            if (n == target) {
                return true;
            }
            if (n > target) {
                c --;
            } else {
                r ++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int rowSize = matrix.length;
        if (rowSize == 0) {
            return false;
        }
        int colSize = matrix[0].length;
        if (colSize == 0) {
            return false;
        }
        return searchMatrix(matrix, 0, rowSize - 1, 0, colSize - 1, target);
    }

    public boolean searchMatrix(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }
        int max = matrix[rowEnd][colEnd];
        int min = matrix[rowStart][colStart];
        if (target < min || target > max) {
            return false;
        }
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;
        int num = matrix[rowMid][colMid];
        if (num == target) {
            return true;
        } else if (num < target) {
            // 右上
            if (searchMatrix(matrix, rowStart, rowMid, colMid + 1, colEnd, target)) {
                return true;
            }
            // 左下
            if (searchMatrix(matrix, rowMid + 1, rowEnd, colStart, colMid, target)) {
                return true;
            }
            // 右下
            return searchMatrix(matrix, rowMid + 1, rowEnd, colMid + 1, colEnd, target);
        } else {
            // 右上
            if (searchMatrix(matrix, rowStart, rowMid - 1, colMid, colEnd, target)) {
                return true;
            }
            // 左下
            if (searchMatrix(matrix, rowMid, rowEnd, colStart, colMid - 1, target)) {
                return true;
            }
            // 左上
            return searchMatrix(matrix, rowStart, rowMid - 1, colStart, colMid - 1, target);
        }
    }
}

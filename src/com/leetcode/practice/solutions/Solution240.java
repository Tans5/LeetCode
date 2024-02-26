package com.leetcode.practice.solutions;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        return colSearch(matrix, target);
    }

    boolean colSearch(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i --) {
            int rowLastValue = matrix[i][matrix[i].length - 1];
            if (rowLastValue == target) {
                return true;
            }
            if (rowLastValue > target) {
                if (rowSearch(matrix[i], target, matrix[i].length)) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    boolean rowSearch(int[] row, int target, int sizeP) {
        int startIndex = 0;
        int size = sizeP;
        while (true) {
            if (size <= 0) {
                return false;
            }
            int midIndex = (startIndex + startIndex + size) / 2;
            int midValue = row[midIndex];
            if (midValue == target) {
                return true;
            }
            if (midValue > target) {
                size = midIndex - startIndex;
            } else {
                size = startIndex + size - midIndex - 1;
                startIndex = midIndex + 1;
            }
        }
    }
}

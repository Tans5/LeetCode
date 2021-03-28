package com.leetcode.practice.solutions;

public class Solution74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int lines = matrix.length;
        int startLine = 0;
        int endLine = lines;
        int targetLine = endLine - 1;

        while (true) {
            int centerLine = (startLine + endLine) / 2;
            if (centerLine + 1 < lines && matrix[centerLine][0] <= target && matrix[centerLine + 1][0] > target) {
                targetLine = centerLine;
                break;
            }
            if (matrix[centerLine][0] < target) {
                if (startLine == centerLine) {
                    break;
                } else {
                    startLine = centerLine;
                }
            } else {
                if (endLine == centerLine) {
                    break;
                } else {
                    endLine = centerLine;
                }
            }
        }
        int startIndex = 0;
        int endIndex = matrix[0].length;
        while (true) {
            int centerIndex = (startIndex + endIndex) / 2;
            if (target == matrix[targetLine][centerIndex]) {
                return true;
            }
            if (matrix[targetLine][centerIndex] > target) {
                if (endIndex == centerIndex) {
                    break;
                } else {
                    endIndex = centerIndex;
                }
            } else {
                if (startIndex == centerIndex) {
                    break;
                } else {
                    startIndex = centerIndex;
                }
            }
        }

        return false;
    }
}

package com.leetcode.practice.solutions;

public class SolutionOffer4 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        int targetX = width - 1;
        int targetY = 0;
        while (true) {
            int num = matrix[targetY][targetX];
            if (num == target) {
                return true;
            }
            if (num < target) {
                targetY ++;
                if (targetY >= height) {
                    return false;
                }
            }
            if (num > target) {
                targetX --;
                if (targetX < 0) {
                    return false;
                }
            }
        }
    }

}

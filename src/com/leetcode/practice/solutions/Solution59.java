package com.leetcode.practice.solutions;

public class Solution59 {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        inputResult(0, n, 1, result);
        return result;
    }

    public static void inputResult(int start, int size, int startNum, int[][] result) {
        if (size > 0) {
            for (int i = start; i < start + size; i ++) {
                result[start][i] = startNum ++;
            }
            for (int i = start + 1; i < start + size - 1; i ++) {
                result[i][start + size - 1] = startNum ++;
            }
            if (size > 1) {
                for (int i = start + size - 1; i >= start; i --) {
                    result[start + size - 1][i] = startNum ++;
                }
                for (int i = start + size - 2; i > start; i --) {
                    result[i][start] = startNum ++;
                }
                if (size - 2 > 0) {
                    inputResult(start + 1, size - 2, startNum, result);
                }
            }
        }
    }
}

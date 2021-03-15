package com.leetcode.practice.solutions;

import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size <= 0) {
            return -1;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < size; i ++) {
            for (int j = 0; j < i + 1; j ++) {
                int value = triangle.get(i).get(j);
                if (j - 1 >= 0 && j != i) {
                    int value1 = dp[i - 1][j - 1];
                    int value2 = dp[i - 1][j];
                    value = value + Math.min(value1, value2);
                } else if (j - 1 >= 0) {
                    value = value + dp[i - 1][j - 1];
                } else {
                    value = value + dp[i - 1][j];
                }
                dp[i][j] = value;
                if (i == size - 1) {
                    if (value < min) {
                        min = value;
                    }
                }
            }

        }
        return min;
    }
}

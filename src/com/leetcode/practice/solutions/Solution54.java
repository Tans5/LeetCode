package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length < 1) {
            return result;
        }
        spiralOrder(
                matrix,
                0,
                matrix.length,
                0,
                matrix[0].length,
                result
        );
        return result;
    }
    public static void spiralOrder(int[][] matrix, int verticalStart, int verticalSize,
                                   int horizontalStart, int horizontalSize, List<Integer> result) {

        for (int i = horizontalStart; i < horizontalStart + horizontalSize; i ++) {
            result.add(matrix[verticalStart][i]);
        }

        for (int i = verticalStart + 1; i < verticalStart + verticalSize - 1; i ++) {
            result.add(matrix[i][horizontalStart + horizontalSize - 1]);
        }

        if (verticalSize > 1) {
            for (int i = horizontalStart + horizontalSize - 1; i >= horizontalStart; i--) {
                result.add(matrix[verticalStart + verticalSize - 1][i]);
            }
        }

        if (horizontalSize > 1) {
            for (int i = verticalStart + verticalSize - 2; i > verticalStart; i--) {
                result.add(matrix[i][horizontalStart]);
            }
        }

        int newVerticalSize = verticalSize - 2;
        int newHorizontalSize = horizontalSize - 2;
        if (newVerticalSize >= 1 && newHorizontalSize >= 1) {
            spiralOrder(matrix,
                    verticalStart + 1,
                    newVerticalSize,
                    horizontalStart + 1,
                    newHorizontalSize,
                    result
            );
        }
    }
}

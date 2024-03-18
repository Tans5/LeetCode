package com.leetcode.practice.solutions;


import java.util.Arrays;

public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        int size = points.length;
        if (size == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] > p2[1]) {
                return 1;
            } else if (p1[1] < p2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int end = points[0][1];
        int result = 1;
        for (int[] p: points) {
            if (p[0] > end) {
                result ++;
                end = p[1];
            }
        }
        return result;
    }
}

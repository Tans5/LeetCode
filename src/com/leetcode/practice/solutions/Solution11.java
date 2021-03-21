package com.leetcode.practice.solutions;

public class Solution11 {
    public static int solution(int[] height) {
        int size = height.length;
        if (size < 2) {
            return 0;
        }
        int start = 0;
        int end = size - 1;
        int result = 0;
        while (true) {
            int area = (end - start) * Math.min(height[start], height[end]);
            if (area > result) {
                result = area;
            }
            if (end - start < 2) {
                break;
            }
            if (height[start] > height[end]) {
                end --;
            } else {
                start ++;
            }
        }
        return result;
    }
}

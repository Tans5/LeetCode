package com.leetcode.practice.solutions;

public class Solution16_05 {

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; Math.pow(5, i) <= n; i ++) {
            count += n / Math.pow(5, i);
        }
        return count;
    }
}

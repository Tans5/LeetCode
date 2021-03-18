package com.leetcode.practice.solutions;

public class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

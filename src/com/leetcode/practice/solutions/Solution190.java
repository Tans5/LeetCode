package com.leetcode.practice.solutions;

public class Solution190 {
    public static int reverseBits(int n) {
        int result = 0;
        int temp;
        for (int i = 0; i < 32; i ++) {
            temp = (1 << (31 - i)) & n;
            result |= temp >>> (31 - i) << i;
        }

        return result;
    }
}

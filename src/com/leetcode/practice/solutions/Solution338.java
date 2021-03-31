package com.leetcode.practice.solutions;

public class Solution338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int count;
        for (int i = 0; i <= num; i ++) {
            count = 0;
            for (int j = 0; j < 31; j ++) {
                if (((1 << j) & i) != 0) {
                    count ++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}

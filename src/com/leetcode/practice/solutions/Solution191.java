package com.leetcode.practice.solutions;

public class Solution191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = n < 0 ? 1 : 0;
        for (int i = 0; i < 31; i ++) {
            if ((1 << i & n) > 0) {
                count ++;
            }
        }
        return count;
    }
}

package com.leetcode.practice.solutions;

public class Solution461 {

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            if ((a >>> i & 1) == 1) {
                count ++;
            }
        }
        return count;
    }

}

package com.leetcode.practice.solutions;

public class Solution2582 {

    public int passThePillow(int n, int time) {
        if (n == 1) {
            return 1;
        }
        int round = time / (n - 1);
        int lastIndex = time % (n - 1);
        if (round % 2 != 0) {
            lastIndex = n - lastIndex;
        } else {
            lastIndex ++;
        }
        return lastIndex;
    }
}

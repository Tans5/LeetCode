package com.leetcode.practice.solutions;

public class Solution1227 {

    public static double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1;
        }
        return 1 / (double) n + ((double) n - 2) / (double) n * nthPersonGetsNthSeat(n - 1);
    }
}

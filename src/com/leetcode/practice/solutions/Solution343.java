package com.leetcode.practice.solutions;

public class Solution343 {
    public static int solution(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int max;
        if (n % 3 == 0) {
            max = (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            int count3 = n / 3 - 1;
            max = (int) Math.pow(3, count3) * 4;
        } else {
            max = (int) Math.pow(3, n / 3) * 2;
        }

        return max;
    }
}

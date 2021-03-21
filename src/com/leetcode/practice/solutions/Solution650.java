package com.leetcode.practice.solutions;

public class Solution650 {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        for (int i = 2; i < n; i ++) {
            if (n % i == 0) {
                result = minSteps(i) + minSteps(n / i);
                break;
            }
            if (i == n - 1) {
                result = n;
            }
        }

        return result;
    }
}

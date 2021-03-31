package com.leetcode.practice.solutions;

public class Solution264 {

    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int count = 0;
        int i = 1;
        while (true) {
            if (isUgly(i)) {
                count ++;
                if (count == n) {
                    break;
                }
            }
            i ++;
        }
        return i;
    }

    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }
            if (n % 3 == 0) {
                n = n / 3;
                continue;
            }
            if (n % 5 == 0) {
                n = n / 5;
                continue;
            }
            return false;
        }
        return true;
    }
}

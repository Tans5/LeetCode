package com.leetcode.practice.solutions;

public class Solution69 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long min = 1;
        long max = x;
        long result = Integer.MIN_VALUE;
        long mid;
        while (max - min > 1) {
            mid = ((min + max) / 2);
            if (mid * mid > x) {
                max = mid;
            } else if (mid * mid == x) {
                result = mid;
                break;
            } else {
                if (mid > result) {
                    result = mid;
                }
                min = mid;
            }
        }
        return (int) result;
    }
}

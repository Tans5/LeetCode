package com.leetcode.practice.solutions.divideandconquer;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class Solution50 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }  else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1.0 / x;
        } else {
            int n1 = n / 2;
            int n2 = n - n1;
            if (n1 == n2) {
                double a = myPow(x, n1);
                return a * a;
            } else {
                return myPow(x, n1) * myPow(x, n2);
            }
        }
    }
}

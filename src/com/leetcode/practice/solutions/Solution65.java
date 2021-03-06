package com.leetcode.practice.solutions;

public class Solution65 {
    public static int add(int a, int b) {
        while(b!=0){
            int tempSum = a ^ b;
            int carrySum = (a & b) << 1;
            a = tempSum;
            b = carrySum;
        }
        return a;
    }
}

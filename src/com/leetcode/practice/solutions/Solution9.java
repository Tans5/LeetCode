package com.leetcode.practice.solutions;

public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int revers = 0;
        int num = x;
        int temp;
        while (num != 0) {
            temp = num % 10;
            num /= 10;
            revers = revers * 10 + temp;
        }
        return revers == x;
    }

}

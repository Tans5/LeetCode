package com.leetcode.practice.solutions;

public class Solution344 {

    public static void reverseString(char[] s) {
        int size = s.length;
        char temp;
        for (int i = 0; i < size / 2; i ++) {
            temp = s[i];
            s[i] = s[size - i - 1];
            s[size - i - 1] = temp;
        }
    }
}

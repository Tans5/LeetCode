package com.leetcode.practice.solutions;

public class Solution409 {

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        char[] upper = new char[26];
        char[] lower = new char[26];
        for (char c: chars) {
            if (c >= 'a') {
                lower[c - 'a'] ++;
            } else {
                upper[c - 'A'] ++;
            }
        }
        for (int i = 0; i < 26; i ++) {
            if (upper[i] % 2 == 0) {
                result += upper[i];
            } else {
                result += upper[i] - 1;
            }
            if (lower[i] % 2 == 0) {
                result += lower[i];
            } else {
                result += lower[i] - 1;
            }
        }
        if (result == chars.length) {
            return result;
        } else {
            return result + 1;
        }
    }
}

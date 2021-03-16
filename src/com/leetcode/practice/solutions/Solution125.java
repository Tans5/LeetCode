package com.leetcode.practice.solutions;

public class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int size = s.length();
        for (int i = 0; i < size / 2; i ++) {
            if (s.charAt(i) != s.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

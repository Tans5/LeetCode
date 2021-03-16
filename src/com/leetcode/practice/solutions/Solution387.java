package com.leetcode.practice.solutions;

public class Solution387 {
    public int firstUniqChar(String s) {
        int[] charsTimes = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i ++) {
            char c = s.charAt(i);
            charsTimes[c - 'a'] = i;
        }
        for (int i = 0; i < size; i ++) {
            int charIndex = s.charAt(i) - 'a';
            if (charsTimes[charIndex] == i) {
                return i;
            } else {
                charsTimes[charIndex] = -1;
            }
        }
        return -1;
    }
}

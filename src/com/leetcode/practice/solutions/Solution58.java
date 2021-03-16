package com.leetcode.practice.solutions;

public class Solution58 {

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int size = words.length;
        if (size == 0) return 0;
        return words[size - 1].length();
    }
}

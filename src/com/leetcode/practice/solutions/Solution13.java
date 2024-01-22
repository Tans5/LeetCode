package com.leetcode.practice.solutions;

public class Solution13 {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            int value = getCharCount(c);
            if (i + 1 < chars.length) {
                int nextValue = getCharCount(chars[i + 1]);
                if (nextValue > value) {
                    value = -value;
                }
            }
            result += value;
        }
        return result;
    }

    private int getCharCount(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

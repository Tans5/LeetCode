package com.leetcode.practice.solutions;

public class Solution14 {


    public static String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if (size <= 0) {
            return "";
        }
        String focusString = strs[0];
        boolean isFinish = false;
        for (String s : strs) {
            if (isFinish) {
                break;
            }
            while (true) {
                if (focusString.length() <= 0) {
                    isFinish = true;
                    break;
                }
                if (!s.startsWith(focusString)) {
                    focusString = focusString.substring(0, focusString.length() - 1);
                } else {
                    break;
                }
            }
        }
        return focusString;
    }
}

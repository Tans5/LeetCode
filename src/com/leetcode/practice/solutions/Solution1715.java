package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution1715 {
    public static String longestWord(String[] words) {
        String result = "";
        int maxLen = 0;
        Arrays.sort(words);
        for (String word: words) {
            if (word.length() > maxLen && !word.isBlank() && isFollowRule(words, word, true)) {
                maxLen = word.length();
                result = word;
            }
        }
        return result;
    }
    public static boolean isFollowRule(String[] words, String except, boolean isFirstCheck) {
        if (except.isBlank()) {
            return true;
        }
        for (String word: words) {
            if (!isFirstCheck || !except.equals(word)) {
                if (except.startsWith(word)) {
                    if (isFollowRule(words, except.replaceFirst(word, ""), false)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

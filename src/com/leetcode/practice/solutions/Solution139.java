package com.leetcode.practice.solutions;

import java.util.List;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        char[][] words = new char[wordDict.size()][];
        for (int i = 0; i < wordDict.size(); i ++) {
            words[i] = wordDict.get(i).toCharArray();
        }
        boolean dp[] = new boolean[chars.length];
        for (int i = 0; i < chars.length; i ++) {
            if (i != 0 && !dp[i - 1]) {
                continue;
            }
            for (char[] word: words) {
                if (isValid(i, chars, word)) {
                    dp[i + word.length - 1] = true;
                }
            }
        }

        return dp[chars.length - 1];
    }
    boolean isValid(int startIndex, char[] chars, char[] word) {
        if (word.length + startIndex > chars.length) {
            return false;
        }
        for (int i = 0; i < word.length; i ++) {
            if (word[i] != chars[startIndex + i]) {
                return false;
            }
        }
        return true;
    }
}

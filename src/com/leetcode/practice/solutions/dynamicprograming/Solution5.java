package com.leetcode.practice.solutions.dynamicprograming;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int maxLenStart = 0;
        dp[0][0] = true;
        for (int end = 1; end < s.length(); end ++) {
            for (int start = 0; start <= end; start ++) {
                if (chars[start] == chars[end]) {
                    int len = end - start + 1;
                    if (len <= 3 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        if (len > maxLen) {
                            maxLen = len;
                            maxLenStart = start;
                        }
                    }
                } else {
                    dp[start][end] = false;
                }
            }
        }
        return new String(chars, maxLenStart, maxLen);
    }
}

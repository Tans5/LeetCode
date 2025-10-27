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

        for (int len = 1; len <= s.length(); len ++) {
            for (int start = 0; start + len <= s.length(); start ++) {
                int end = start + len - 1;
                if (start == end) {
                    dp[start][end] = true;
                    continue;
                }
                if (len == 2) {
                    dp[start][end] = chars[start] == chars[end];
                } else {
                    dp[start][end] = dp[start + 1][end - 1] && chars[start] == chars[end];
                }
                if (len > maxLen && dp[start][end]) {
                    maxLen = len;
                    maxLenStart = start;
                }
            }
        }
        return new String(chars, maxLenStart, maxLen);
    }
}

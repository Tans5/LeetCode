package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Solution131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int end = 0; end < chars.length; end ++) {
            for (int start = 0; start <= end; start ++) {
                if (start == end) {
                    dp[start][end] = true;
                } else if(chars[start] == chars[end] && start + 1 == end) {
                    dp[start][end] = true;
                } else if (chars[start] == chars[end] && ((end - start + 1) > 2 && (start + 1) < chars.length) && (end - 1) >= 0 && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }
        backtracking(chars, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtracking(char[] chars, int start, List<String> state, List<List<String>> result, boolean[][] dp) {
        if (start >= chars.length) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < chars.length; i ++) {
            if (dp[start][i]) {
                state.add(new String(chars, start, i - start + 1));
                backtracking(chars, i + 1, state, result, dp);
                state.remove(state.size() - 1);
            }
        }
    }
}

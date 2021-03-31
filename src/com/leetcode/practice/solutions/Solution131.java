package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution131 {

    public static List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        List<List<String>> result = new ArrayList<>();
        if (size < 1) {
            return result;
        }
        boolean[][] dp = new boolean[size][size];
        for (int end = 0; end < size; end ++) {
            for (int start = 0; start <= end; start ++) {
                if (chars[end] == chars[start] && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }
        findResult(0, size, chars, result, new ArrayDeque<>(), dp);
        return result;
    }

    public static void findResult(int start, int end, char[] chars, List<List<String>> result, Deque<String> history, boolean[][] dp) {
        if (start >= end) {
            result.add(new ArrayList<>(history));
        }
        for (int i = start; i < end; i ++) {
            if (dp[start][i]) {
                history.add(new String(chars, start, i - start + 1));
                findResult(i + 1, end, chars, result, history, dp);
                history.removeLast();
            }
        }
    }
}

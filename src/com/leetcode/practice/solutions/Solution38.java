package com.leetcode.practice.solutions;

public class Solution38 {

    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        String[] dp = new String[n];
        dp[0] = "1";
        for (int i = 1; i < n; i ++) {
            dp[i] = genString(dp[i - 1]);
        }
        return dp[n - 1];
    }

    private String genString(String lastString) {
        StringBuilder result = new StringBuilder();
        char lastChar = lastString.charAt(0);
        int lastCharCount = 0;
        for (int i = 0; i < lastString.length(); i ++) {
            char c = lastString.charAt(i);
            if (c == lastChar) {
                lastCharCount ++;
            } else {
                result.append(lastCharCount);
                result.append(lastChar);
                lastChar = c;
                lastCharCount = 1;
            }
        }
        result.append(lastCharCount);
        result.append(lastChar);
        return result.toString();
    }
}

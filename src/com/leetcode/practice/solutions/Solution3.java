package com.leetcode.practice.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if (size <= 0) {
            return 0;
        }
        Set<Character> history = new HashSet<>();
        int maxLen = 1;
        int start = 0;
        int end = 0;
        int len = 1;
        char[] chars = s.toCharArray();
        for (; start < chars.length - 1; start ++) {
            if (start > 0) {
                history.remove(chars[start - 1]);
            }
            if (maxLen >= chars.length - start) {
                break;
            }
            for (; end < chars.length; end ++) {
                if (history.contains(chars[end])) {
                    len = end - start;
                    break;
                } else {
                    len = end - start + 1;
                    history.add(chars[end]);
                }
            }
            if (len > maxLen) {
                maxLen = len;
            }

        }
        return maxLen;
    }
}

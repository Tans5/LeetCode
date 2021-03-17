package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if (size <= 0) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        int maxLen = 1;
        int start = 0;
        int end = 0;
        int len = 1;
        for (start = 0; start < size - 1; start ++) {
            if (start > 0) {
                Integer historyCount = count.get(s.charAt(start - 1));
                if (historyCount != null && historyCount > 0) {
                    count.put(s.charAt(start - 1), historyCount - 1);
                } else {
                    count.put(s.charAt(start - 1), 0);
                }
            }
            for (; end < size; end ++) {
                Integer historyCount = count.get(s.charAt(end));
                if (historyCount != null && historyCount > 0) {
                    len = end - start;
                    break;
                } else {
                    len = end - start + 1;
                    count.put(s.charAt(end), 1);
                }
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}

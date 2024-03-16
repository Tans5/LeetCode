package com.leetcode.practice.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution3_2 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> history = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 1;
        history.add(chars[0]);
        while (left <= right && right < chars.length) {
            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }
            right ++;
            if (right < chars.length) {
                char c = chars[right];
                while (left <= right && history.contains(c)) {
                    history.remove(chars[left]);
                    left ++;
                }
                history.add(c);
            }
        }

        return maxLen;
    }
}

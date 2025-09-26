package com.leetcode.practice.interview;

import java.util.Arrays;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Bytedance2 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] charsIndex = new int[128];
        Arrays.fill(charsIndex, - 1);
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < chars.length) {
            char rc = chars[right];
            int rcIndex = charsIndex[rc];
            if (rcIndex == -1 || rcIndex < left) {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
                charsIndex[rc] = right;
            } else {
                left = rcIndex + 1;
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
                charsIndex[rc] = right;
            }

            right ++;
        }
        return maxLen;
    }
}

package com.leetcode.practice.solutions.array;

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
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = 0;
        int longest = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        int right = 0;
        for (; right < s.length(); right ++) {
            char c = s.charAt(right);
            if (charIndex[c] == -1 || charIndex[c] < left) { // left 后面没有记录过当前 char 的 index，长度 + 1，记录当前的 char index 为 right
                length ++;
                charIndex[c] = right;
            } else { // 当前 char index 已经记录过了，将上次的 index + 1 作为新的 left
                int lastIndex = charIndex[c];
                left = lastIndex + 1;
                length = right - left + 1;
                charIndex[c] = right;
            }
            if (length > longest) {
                longest = length;
            }
        }

        return longest;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = 0;
        int longest = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (charIndex[c] == -1) {
                charIndex[c] = i;
                length ++;
            } else {
                int lastIndex = charIndex[c];
                for (int j = 0; j < charIndex.length; j ++) {
                    if (charIndex[j] != -1 && charIndex[j] < lastIndex) {
                        charIndex[j] = -1;
                    }
                }
                length = i - lastIndex;
                charIndex[c] = i;
            }
            if (length > longest) {
                longest = length;
            }
        }
        return longest;
    }
}

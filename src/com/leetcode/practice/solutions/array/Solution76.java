package com.leetcode.practice.solutions.array;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        int windowLength = t.length();
        int length = s.length();
        if (windowLength > length || length == 0) {
            return "";
        }
        int[] windowCount = new int[128];
        int[] targetWindowCount = new int[128];
        int needFormatChars = 0;
        for (int i = 0; i < windowLength; i ++) {
            targetWindowCount[t.charAt(i)] ++;
        }
        for (int j : targetWindowCount) {
            if (j > 0) {
                needFormatChars++;
            }
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = -1;
        int formatChars = 0;
        // 先向右移动 right，直到覆盖 t.
        // 然后再向右移动 left，收缩窗口，直到不再覆盖 t，然后再去向右移动 right，直到覆盖 t，反复这个过程，记录满足条件的最小的 len。
        while (left <= right && right < length) {
            windowCount[s.charAt(right)] ++;
            if (windowCount[s.charAt(right)] == targetWindowCount[s.charAt(right)]) {
                formatChars ++;
            }
            while (formatChars == needFormatChars && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                windowCount[s.charAt(left)] --;
                if (targetWindowCount[s.charAt(left)] != 0 && windowCount[s.charAt(left)] < targetWindowCount[s.charAt(left)]) {
                    formatChars --;
                }
                left ++;
            }
            right ++;
        }
        if (minLeft != -1) {
            return new String(s.toCharArray(), minLeft, minLen);
        } else {
            return "";
        }
    }
}

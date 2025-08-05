package com.leetcode.practice.solutions.array;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class Solution567 {

    // abcdxabcde
    // abcdeabcdx
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int windowSize = s1.length();
        int[] targetCharsWindowSize = new int[128];
        for (int i = 0; i < windowSize; i ++) {
            targetCharsWindowSize[s1.charAt(i)] ++;
        }
        int targetWindowCharTypeSize = 0;
        for (int i : targetCharsWindowSize) {
            if (i > 0) {
                targetWindowCharTypeSize ++;
            }
        }
        int start = 0;
        int end = 0;
        int[] charsWindowSize = new int[128];
        int windowCharTypeSize = 0;
        while (start <= end && end < s2.length()) {
            char ec = s2.charAt(end);
            charsWindowSize[ec] ++;
            if (charsWindowSize[ec] == targetCharsWindowSize[ec]) {
                windowCharTypeSize ++;
            }
            while (windowCharTypeSize == targetWindowCharTypeSize && start <= end) {
                if (end - start + 1 == windowSize) {
                    return true;
                }
                char sc = s2.charAt(start);
                charsWindowSize[sc] --;
                if (targetCharsWindowSize[sc] != 0 && charsWindowSize[sc] < targetCharsWindowSize[sc]) {
                    windowCharTypeSize --;
                }
                start ++;
            }
            end ++;
        }
        return false;
    }
}

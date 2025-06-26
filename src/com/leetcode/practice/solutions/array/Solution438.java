package com.leetcode.practice.solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 (字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。) 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length() || p.isEmpty()) {
            return result;
        }
        int[] window = new int[26];
        int[] targetWindow = new int[26];

        for (int i = 0; i < p.length(); i ++) {
            targetWindow[p.charAt(i) - 'a'] ++;
        }
        int targetCharNum = 0;
        for (int n : targetWindow) {
            if (n > 0) {
                targetCharNum++;
            }
        }
        int left = 0;
        int right = 0;
        int charNum = 0;
        while (left <= right && right < s.length()) {
            int charIndex = s.charAt(right) - 'a';
            window[charIndex] ++;
            if (window[charIndex] == targetWindow[charIndex]) {
                charNum ++;
            }
            while (charNum == targetCharNum && left <= right) {
                if (right - left + 1 == p.length()) {
                    result.add(left);
                }
                int leftCharIndex = s.charAt(left) - 'a';
                window[leftCharIndex] --;
                if (targetWindow[leftCharIndex] != 0 && window[leftCharIndex] < targetWindow[leftCharIndex]) {
                    charNum --;
                }
                left ++;
            }
            right ++;
        }

        return result;
    }
}

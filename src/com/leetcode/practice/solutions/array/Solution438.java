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
        int[] pCharsUseTimes = new int[26];
        int[] sCharsUseTimes = new int[26];
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i ++) {
            pCharsUseTimes[p.charAt(i) - 'a'] ++;
            sCharsUseTimes[s.charAt(i) - 'a'] ++;
        }
        if (isSame(pCharsUseTimes, sCharsUseTimes)) {
            result.add(0);
        }
        for (int i = 1; i <= s.length() - windowSize; i ++) {
            sCharsUseTimes[s.charAt(i - 1) - 'a'] --;
            sCharsUseTimes[s.charAt(i + windowSize - 1) - 'a'] ++;
            if (isSame(pCharsUseTimes, sCharsUseTimes)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSame(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i ++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}

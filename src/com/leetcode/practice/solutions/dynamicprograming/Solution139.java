package com.leetcode.practice.solutions.dynamicprograming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length + 1];
        dp[0] = true;
        for (int i = 0; i < chars.length; i ++) {
            if (!dp[i]) {
                continue;
            }
            for(String word: wordDict) {
                int wordLen = word.length();
                if (i + wordLen > chars.length) {
                    continue;
                }
                boolean isOk = true;
                for (int j = i; j < i + wordLen; j ++) {
                    if (chars[j] != word.charAt(j - i)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    dp[i + wordLen] = true;
                }
            }
        }
        return dp[chars.length];
    }
}

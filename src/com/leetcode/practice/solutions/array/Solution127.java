package com.leetcode.practice.solutions.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 *
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 * 提示：
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 */
public class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // pattern 到 words 的 Map
        Map<String, List<String>> patternToWords = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < word.length(); i ++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = patternToWords.computeIfAbsent(pattern, (key) -> {return new ArrayList<>();});
                list.add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        // 访问分为两个集合.
        Set<String> front = new HashSet<>();
        front.add(beginWord);

        Set<String> back = new HashSet<>();
        back.add(endWord);
        int deep = 1;
        while (!front.isEmpty() && !back.isEmpty()) {
            if (back.size() < front.size()) { // 保证当前访问的集合数量较少，提高性能。
                Set<String> temp = front;
                front = back;
                back = temp;
            }
            Set<String> next = new HashSet<>(); // 下一次访问的单词
            for (String word: front) {
                // 找到当前单词的邻居，作为下一次遍历的集合
                for (int i = 0; i < word.length(); i ++) {
                    String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                    List<String> neighbors = patternToWords.get(pattern);
                    if (neighbors != null) {
                        for (String neighbor: neighbors) {
                            if (back.contains(neighbor)) { // 两个访问集合已经相遇，找到答案。
                                return deep + 1;
                            }
                            if (!visited.add(neighbor)) {
                                continue;
                            }
                            next.add(neighbor);
                        }
                    }
                }
            }
            front = next;
            deep ++;
        }

        return 0;
    }
}

package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> p2Words = new HashMap<>();
        Map<String, Character> words2P = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if ((p2Words.containsKey(c) && !p2Words.get(c).equals(word)) || (words2P.containsKey(word) && words2P.get(word) != c)) {
                return false;
            }
            p2Words.put(c, word);
            words2P.put(word, c);
        }

        return true;
    }
}

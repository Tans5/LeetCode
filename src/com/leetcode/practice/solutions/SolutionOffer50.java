package com.leetcode.practice.solutions;

import java.util.LinkedHashMap;
import java.util.Map;

public class SolutionOffer50 {

    public static char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> history = new LinkedHashMap<Character, Integer>(16, 0.75f, true);
        char[] chars = s.toCharArray();
        for (Character c: chars) {
            history.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry: history.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

}

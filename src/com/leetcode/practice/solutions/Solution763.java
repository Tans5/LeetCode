package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer>[] charsRange = new ArrayList[26];
        for (int i = 0; i < chars.length; i ++) {
            int charIndex = chars[i] - 'a';
            ArrayList<Integer> range = charsRange[charIndex];
            if (range == null) {
                range = new ArrayList<>(2);
                range.add(i);
                range.add(i);
                charsRange[charIndex] = range;
            } else {
                range.set(1, i);
            }
        }

        List<Integer> result = new ArrayList<>();

        int startIndex = 0;
        int maxEndIndex = 0;
        int countSum = 0;
        for (int i = 0; i < chars.length; i ++) {
            int charIndex = chars[i] - 'a';
            ArrayList<Integer> range = charsRange[charIndex];
            if (i > maxEndIndex) {
                int count = maxEndIndex - startIndex + 1;
                result.add(count);
                startIndex = i;
                maxEndIndex = range.get(1);
                countSum += count;
                continue;
            }
            if (range.get(1) > maxEndIndex) {
                maxEndIndex = range.get(1);
            }
        }
        if (countSum < chars.length) {
            result.add(chars.length - countSum);
        }

        return result;
    }
}

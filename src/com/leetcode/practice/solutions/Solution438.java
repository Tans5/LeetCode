package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int size = s.length();
        int pSize = p.length();
        if (pSize > size) {
            return result;
        }
        int[] anchor = new int[26];
        for (int i = 0; i < pSize; i ++) {
            anchor[p.charAt(i) - 'a'] ++;
        }
        int[] window = new int[26];
        for (int start = 0; start < size - pSize + 1; start ++) {
            Arrays.fill(window, 0);
            for (int i = start; i < start + pSize; i ++) {
                window[s.charAt(i) - 'a'] ++;
            }
            for (int i = 0; i < 26; i ++) {
                if (window[i] != anchor[i]) {
                    break;
                }
                if (i == 25) {
                    result.add(start);
                }
            }
        }
        return result;
    }
}

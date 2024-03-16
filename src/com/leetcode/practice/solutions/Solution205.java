package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2T = new HashMap<>();
        Map<Character, Character> t2S = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((s2T.containsKey(sc) && s2T.get(sc) != tc) || (t2S.containsKey(tc) && t2S.get(tc) != sc)) {
                return false;
            }
            s2T.put(sc, tc);
            t2S.put(tc, sc);
        }
        return true;
    }

}

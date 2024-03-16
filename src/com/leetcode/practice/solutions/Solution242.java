package com.leetcode.practice.solutions;

public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharsTimes = new char[26];
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            sCharsTimes[c - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            if (sCharsTimes[c - 'a'] > 0) {
                sCharsTimes[c - 'a'] --;
            } else {
                return false;
            }
        }

        return true;
    }
}

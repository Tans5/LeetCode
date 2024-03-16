package com.leetcode.practice.solutions;

public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.isEmpty()) {
            return false;
        }
        if (ransomNote.isEmpty()) {
            return true;
        }
        char[] magazineChars = magazine.toCharArray();
        int[] charsPool = new int[26];
        for (char c: magazineChars) {
            charsPool[c - 'a'] ++;
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char c: ransomNoteChars) {
            int count = charsPool[c - 'a'];
            if (count <= 0) {
                return false;
            } else {
                charsPool[c - 'a'] --;
            }
        }
        return true;
    }

}

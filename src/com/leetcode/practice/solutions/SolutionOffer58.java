package com.leetcode.practice.solutions;

public class SolutionOffer58 {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        int size = words.length;
        for (int i = size - 1; i >= 0; i --) {
            if (words[i].isBlank()) {
                continue;
            }
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString().trim();
    }

}

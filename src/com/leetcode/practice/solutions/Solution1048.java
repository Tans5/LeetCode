package com.leetcode.practice.solutions;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Solution1048 {

    public static int longestStrChain(String[] words) {
        int size = words.length;
        char[][] wordsC = new char[size][];
        for (int i = 0; i < size; i ++) {
            wordsC[i] = words[i].toCharArray();
        }
        Arrays.sort(wordsC, Comparator.comparingInt(o -> o.length));
        return findMaxLen(0, wordsC, new ArrayDeque<>());
    }

    public static int findMaxLen(int start, char[][] words, Deque<char[]> deque) {
        int size = words.length;
        if (start > size - 1) {
            return deque.size();
        }
        int maxLen = 1;
        int len;
        for (int i = start; i < size; i ++) {
            if (deque.isEmpty() || isPreChars(deque.peek(), words[i])) {
                deque.push(words[i]);
                len = Math.max(findMaxLen(i + 1, words, deque), deque.size());
                if (len > maxLen) {
                    maxLen = len;
                }
                deque.pop();
            }
        }
        return maxLen;
    }

    public static boolean isPreChars(char[] preChars, char[] nextChars) {
        int preCharSize = preChars.length;
        if (preCharSize != nextChars.length - 1) {
            return false;
        }
        boolean isFindDiffer = false;
        for (int i = 0; i < preCharSize; i ++) {
            if (isFindDiffer) {
                if (preChars[i] != nextChars[i + 1]) {
                    return false;
                }
            } else {
                if (preChars[i] != nextChars[i]) {
                    isFindDiffer = true;
                    i--;
                }
            }
        }
        return true;
    }

}

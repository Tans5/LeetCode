package com.leetcode.practice.solutions;

public class Solution76 {
    public static String minWindow(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();
        if (tSize > sSize) {
            return "";
        }
        int[] anchor = new int[52];
        for (int i = 0; i < tSize; i ++) {
            enqueueChar(anchor, t.charAt(i));
        }
        int[] target = new int[52];
        int minLen = Integer.MAX_VALUE;
        String result = "";
        int start = 0;
        int end = 0;
        enqueueChar(target, s.charAt(0));
        while (start < sSize) {
            if (isOk(anchor, target)) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                dequeueChar(target, s.charAt(start));
                start ++;
            } else {
                end ++;
                if (end >= sSize) {
                    break;
                } else {
                    enqueueChar(target, s.charAt(end));
                }
            }
        }

        return result;
    }

    public static void enqueueChar(int[] target, char c) {
        if (c >= 'A' && c <= 'Z') {
            target[c - 'A'] ++;
        } else {
            target[c - 'a' + 26] ++;
        }
    }

    public static void dequeueChar(int[] target, char c) {
        if (c >= 'A' && c <= 'Z') {
            target[c - 'A'] --;
        } else {
            target[c - 'a' + 26] --;
        }
    }

    public static boolean isOk(int[] anchor, int[] target) {
        for (int i = 0; i < 52; i ++) {
            if (anchor[i] > 0 && target[i] < anchor[i]) {
                return false;
            }
        }
        return true;
    }
}

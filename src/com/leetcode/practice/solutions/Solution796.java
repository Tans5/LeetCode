package com.leetcode.practice.solutions;

public class Solution796 {

    public static boolean rotateString(String A, String B) {
        int size = A.length();
        if (size != B.length()) return false;
        if (size == 0) return true;
        if (size == 1) return A.equals(B);
        StringBuilder aBuilder = new StringBuilder(A);
        char aLast;
        boolean isOk;
        for (int i = 1; i < size; i ++) {
            aLast = aBuilder.charAt(size - 1);
            isOk = true;
            for (int j = size - 1; j > - 1; j --) {
                char c;
                if (j == 0) {
                    c = aLast;
                } else {
                    c = aBuilder.charAt(j - 1);
                }
                if (isOk && c != B.charAt(j)) {
                    isOk = false;
                }
                aBuilder.setCharAt(j, c);
            }
            if (isOk) {
                return true;
            }
        }
        return false;
    }
}

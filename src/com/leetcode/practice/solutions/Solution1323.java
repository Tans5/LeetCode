package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution1323 {

    public static int maximum69Number (int num) {
        char[] numChars = Integer.toString(num).toCharArray();
        int size = numChars.length;
        for (int i = 0; i < size; i ++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.copyValueOf(numChars));
    }

}

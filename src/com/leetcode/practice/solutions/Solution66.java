package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution66 {

    public static int[] plusOne(int[] digits) {
        boolean needUp = true;
        for (int i: digits) {
            if (i != 9) {
                needUp = false;
                break;
            }
        }
        int[] result;
        int size = digits.length;
        if (!needUp) {
            result = Arrays.copyOf(digits, size);
        } else {
            result = new int[size + 1];
            result[0] = 1;
            return result;
        }
        for (int i = size - 1; i >= 0; i --) {
            int v = result[i];
            if (v == 9) {
                result[i] = 0;
            } else {
                result[i] = v + 1;
                break;
            }
        }

        return result;
    }
}

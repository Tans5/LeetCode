package com.leetcode.practice.solutions;

public class Solution8 {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int charLen = chars.length;
        int[] nums = new int[charLen];
        int numCharLen = 0;
        for (int i = 0; i < charLen; i ++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                int n = cToInt(c);
                nums[numCharLen] = n;
                numCharLen ++;
            } else {
                if ((c == '-' || c == '+') && i == 0) {
                    continue;
                } else {
                    break;
                }
            }
        }
        int max = Integer.MAX_VALUE;
        int maxLen = 10;
        int maxNum = 2;
        int min = Integer.MIN_VALUE;
        int minLen = 10;
        int minNum = 2;
//        for (int temp = max; temp > 0; temp = temp / 10) {
//            maxLen ++;
//        }
//        int maxLenValue = (int)Math.pow(10, maxLen - 1);
//        int maxNum = max / maxLenValue;
//        for (int temp = min; temp < 0; temp = temp / 10) {
//            minLen ++;
//        }
//        int minLenValue = (int)Math.pow(10, minLen - 1);
//        int minNum = min / minLenValue * -1;
        boolean isPositive = chars[0] != '-';
        int result = 0;
        for (int i = 0; i < numCharLen; i ++) {
            int lenValue = numCharLen - i;
            int n = nums[i];
            if (isPositive) {
                if (lenValue > maxLen && n != 0) {
                    return max;
                }
                if (lenValue == maxLen && n > maxNum && n != 0) {
                    return max;
                }
                int value = n * (int) Math.pow(10, lenValue - 1);
                if (max - result > value) {
                    result += value;
                } else {
                    return max;
                }
            } else {
                if (lenValue > minLen & n != 0) {
                    return min;
                }
                if (lenValue == minLen && n > minNum & n != 0) {
                    return min;
                }
                int value = n * (int) Math.pow(10, lenValue - 1) * -1;
                if (value > min - result) {
                    result += value;
                } else {
                    return min;
                }
            }
        }
        return result;
    }

    private int cToInt(char c) {
        switch (c) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: return 0;
        }
    }
}

package com.leetcode.practice.solutions;

public class Solution394 {

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        decodeString(s.toCharArray(), 0, s.length(), result);
        return result.toString();
    }

    void decodeString(char[] s, int startIndex, int size, StringBuilder result) {
        int encodeNum = -1;
        int encodeStartIndex = -1;
        int leftCount = 0;
        for (int i = startIndex; i < startIndex + size; i ++) {
            char c = s[i];
            if (encodeStartIndex == -1) {
                if (isNumber(c)) {
                    int[] numAndNewIndex = decodeNumber(s, i);
                    encodeNum = numAndNewIndex[0];
                    encodeStartIndex = numAndNewIndex[1] + 1;
                    i = encodeStartIndex;
                } else {
                    result.append(c);
                }
                continue;
            }
            if (c == '[') {
                leftCount ++;
                continue;
            }
            if (c == ']') {
                if (leftCount == 0) {
                    StringBuilder lsb = new StringBuilder();
                    decodeString(s, encodeStartIndex, i - encodeStartIndex, lsb);
                    result.append(lsb.toString().repeat(Math.max(0, encodeNum)));
                    encodeNum = -1;
                    encodeStartIndex = -1;
                } else {
                    leftCount --;
                }
            }
        }
    }

    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     *
     * @param chars
     * @param startIndex ()
     * @return
     */
    int[] decodeNumber(char[] chars, int startIndex) {
        int numberSize = 0;
        for (int i = startIndex; i < chars.length; i ++) {
            if (isNumber(chars[i])) {
                numberSize ++;
            } else {
                break;
            }
        }
        int number = 0;
        for (int i = 0; i < numberSize; i ++) {
            number += (chars[startIndex + i] - '0') * (int) Math.pow(10, numberSize - i - 1);
        }
        return new int[] {number, startIndex + numberSize};
    }
}

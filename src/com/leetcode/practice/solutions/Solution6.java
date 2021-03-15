package com.leetcode.practice.solutions;

public class Solution6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] resultArray = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        int size = s.length();
        int cycle = numRows + numRows - 2;
        for (int i = 0; i < size; i = i + cycle) {
            for (int j = i; j < i + cycle && j < size; j ++) {
                int index;
                if (j % cycle < numRows) {
                    index = j % cycle;
                } else {
                    index = numRows - (j % cycle + 1 - numRows) - 1;
                }
                if (resultArray[index] == null) {
                    resultArray[index] = new StringBuilder();
                }
                resultArray[index].append(s.charAt(j));
            }
        }
        for (StringBuilder string: resultArray) {
            if (string != null) {
                result.append(string);
            }
        }
        return result.toString();
    }
}

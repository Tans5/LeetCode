package com.leetcode.practice.solutions;

public class Solution32 {

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        String[][] chars = new String[][] {
                new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                new String[] {"", "M", "MM", "MMM"}
        };
        StringBuilder result = new StringBuilder();
        result.append(chars[3][num / 1000]);
        result.append(chars[2][(num % 1000) / 100]);
        result.append(chars[1][(num % 100) / 10]);
        result.append(chars[0][(num % 10)]);
        return result.toString();
    }
}

package com.leetcode.practice.solutions;

public class StringToInt {
    public static int strToInt(String str) {
        char[] chars = str.toCharArray();
        int size = chars.length;
        int result = 0;
        if (size > 0) {
            boolean isUpZero = true;
            if (chars[0] == '-') {
                char[] newChars = new char[-- size];
                System.arraycopy(chars, 1, newChars, 0, size);
                chars = newChars;
                isUpZero = false;
            } else {
                if (chars[0] == '+') {
                    char[] newChars = new char[-- size];
                    System.arraycopy(chars, 1, newChars, 0, size);
                    chars = newChars;
                }
                isUpZero = true;
            }
            for (int i = 0; i < size; i ++) {
                result += charToInt(chars[i]) * Math.pow(10, size - i - 1);
            }
            return isUpZero ? result : result * -1;
        }

        return result;
    }

    public static int charToInt(char c) {
        switch (c) {
            case '0' -> {
                return 0;
            }
            case '1' -> {
                return 1;
            }
            case '2' -> {
                return 2;
            }
            case '3' -> {
                return 3;
            }
            case '4' -> {
                return 4;
            }
            case '5' -> {
                return 5;
            }
            case '6' -> {
                return 6;
            }
            case '7' -> {
                return 7;
            }
            case '8' -> {
                return 8;
            }
            case '9' -> {
                return 9;
            }
            default -> throw new RuntimeException("Wrong char: " + c);
        }
    }

    public static void main(String[] args) {
        int result = strToInt("12345678");
        System.out.println(result);
    }
}

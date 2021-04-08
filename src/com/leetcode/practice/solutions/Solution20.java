package com.leetcode.practice.solutions;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (isLeft(c)) {
                deque.push(c);
            } else {
                if (deque.isEmpty() || !isCouple(deque.pop(), c)) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static boolean isCouple(char start, char end) {
        switch (start) {
            case '(': {
                return end == ')';
            }
            case '[': {
                return end == ']';
            }
            case '{': {
                return end == '}';
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

}

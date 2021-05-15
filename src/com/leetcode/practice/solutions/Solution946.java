package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution946 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        final int size = pushed.length;
        int pushedIndex = 0;

        for (Integer num: popped) {

            while (true) {
                if (pushedIndex >= size && !num.equals(stack.peek())) {
                    return false;
                }
                if (pushedIndex < size && num == pushed[pushedIndex]) {
                    pushedIndex ++;
                    break;
                }
                if (!stack.isEmpty() && stack.peek().equals(num)) {
                    stack.pop();
                    break;
                }
                if (pushedIndex < size) {
                    stack.push(pushed[pushedIndex]);
                    pushedIndex ++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

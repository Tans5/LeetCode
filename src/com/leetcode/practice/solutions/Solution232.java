package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution232 {

    Deque<Integer> stackIn = new ArrayDeque<>();
    Deque<Integer> stackOut = new ArrayDeque<>();

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                Integer value = stackIn.pop();
                stackOut.push(value);
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                Integer value = stackIn.pop();
                stackOut.push(value);
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}

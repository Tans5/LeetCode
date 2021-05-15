package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionOffer30 {
}


class MinStack {
    final Deque<Integer> stack = new ArrayDeque<>();
    final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        Integer min = minStack.peek();
        if (min == null || x <= min) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer popNum = stack.pop();
        if (popNum.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}


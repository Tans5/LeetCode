package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution155 {

    class MinStack {
        Deque<Integer> minDeque = new ArrayDeque<>();
        {
            minDeque.push(Integer.MAX_VALUE);
        }
        Deque<Integer> deque = new ArrayDeque<>();

        public MinStack() { }

        public void push(int val) {
            if (val <= minDeque.peek()) {
                minDeque.push(val);
            }
            deque.push(val);
        }

        public void pop() {
            if (deque.peek().equals(minDeque.peek())) {
                minDeque.pop();
            }
            deque.pop();
        }

        public int top() {
            return deque.peek();
        }

        public int getMin() {
            return minDeque.peek();
        }
    }

}

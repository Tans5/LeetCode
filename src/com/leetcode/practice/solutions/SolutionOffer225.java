package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionOffer225 {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}


class MyStack {
    private final Queue<Integer> queue1 = new ArrayDeque<>();
    private final Queue<Integer> queue2 = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.size() == 1) {
            return queue1.poll();
        }
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        if (queue1.size() == 1) {
            return queue1.peek();
        }
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }
            return queue1.peek();
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

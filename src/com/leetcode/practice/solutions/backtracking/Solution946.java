package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class Solution946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> readyToPush = new LinkedList<>();
        for (int p: pushed) {
            readyToPush.offer(p);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> poppedQueue = new LinkedList<>();
        return backTrack(readyToPush, stack, poppedQueue, popped);
    }

    private boolean backTrack(LinkedList<Integer> readyToPush, LinkedList<Integer> stack, LinkedList<Integer> poppedQueue, int[] toCheckPopped) {
        if (poppedQueue.size() == toCheckPopped.length) {
            return true;
        }
        if (!stack.isEmpty()) {
            int first = stack.peekFirst();
            if (toCheckPopped[poppedQueue.size()] == first) {
                int popped = stack.pop();
                poppedQueue.offer(popped);
                if (backTrack(readyToPush, stack, poppedQueue, toCheckPopped)) {
                    return true;
                }
                stack.push(popped);
                poppedQueue.removeLast();
            }
        }
        if (!readyToPush.isEmpty()) {
            int toPush = readyToPush.poll();
            stack.push(toPush);
            if (backTrack(readyToPush, stack, poppedQueue, toCheckPopped)) {
                return true;
            }
            stack.pop();
            readyToPush.add(0, toPush);
        }

        return false;
    }


    public boolean validateStackSequences2(int[] pushed, int[] popped) {
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

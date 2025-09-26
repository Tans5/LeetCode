package com.leetcode.practice.interview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定入栈顺序为 1, 2, 3, ..., n（即固定顺序），求有多少种可能的出栈顺序。
 *
 * n = 1, [1]
 * n = 2, [1, 2], [2, 1]
 * n = 3, [1, 2, 3], [2, 1, 3], [3, 2, 1], [3, 1, 2], [2, 3, 1]
 */
public class Tencent1 {

    /**
     *
     * @param n 入栈元素数量
     * @return
     */
    public int popStackWays(int n) {
        int[] ret = new int[1];
        backtrack(n, 0, ret);
        return ret[0];
    }

    private void backtrack(int readyPutToStack, int stack, int[] result) {
        if (readyPutToStack <= 0 && stack <= 0) { // 完成
            result[0] ++;
            return;
        }
        if (stack > 0) { // 当前栈不为空, 尝试出栈
            backtrack(readyPutToStack, stack - 1, result);
        }
        if (readyPutToStack > 0) { // 等待入栈不为空, 尝试入栈
            backtrack(readyPutToStack - 1, stack + 1, result);
        }
    }


    public List<List<Integer>> allPopStackWays(int n) {
        LinkedList<Integer> readyPushStack = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            readyPushStack.add(i);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> popStackQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(readyPushStack, stack, popStackQueue, result);
        return result;
    }

    private void backtrack(
            LinkedList<Integer> readyPushStack,
            LinkedList<Integer> stack,
            LinkedList<Integer> popStackQueue,
            List<List<Integer>> result) {
        if (readyPushStack.isEmpty() && stack.isEmpty()) {
            result.add(new ArrayList<>(popStackQueue));
            return;
        }
        if (!stack.isEmpty()) { // 尝试出栈
            int pop = stack.pop();
            popStackQueue.offer(pop);
            backtrack(readyPushStack, stack, popStackQueue, result);
            popStackQueue.removeLast();
            stack.push(pop);
        }

        if (!readyPushStack.isEmpty()) { // 尝试入栈
            int toPush = readyPushStack.poll();
            stack.push(toPush);
            backtrack(readyPushStack, stack, popStackQueue, result);
            stack.pop();
            readyPushStack.add(0, toPush);
        }
    }

    /**
     *
     * 动态规划推导
     * 1. 定义状态
     * 令 dp[i]表示 i个元素（入栈顺序为 1,2,...,i）的所有可能出栈顺序的数量。
     *
     * 2. 基础情况
     * 当 i = 0时（没有元素），只有一种"出栈顺序"：空序列。所以 dp[0] = 1。
     *
     * 当 i = 1时，只有一个元素，只能有一种出栈顺序：[1]。所以 dp[1] = 1。
     *
     * 3. 状态转移方程
     * 考虑 i个元素的情况（入栈顺序为 1,2,...,i）。我们可以根据第一个出栈的元素来划分所有可能的出栈序列：
     *
     * 如果第一个出栈的元素是 k（1 ≤ k ≤ i）
     *
     * 那么，在 k出栈之前：
     *
     * 元素 1 到 k-1 必须已经入栈（因为它们比 k先入栈）
     *
     * 但这些元素还没有出栈（因为 k是第一个出栈的）
     *
     * 在 k出栈之后：
     *
     * 栈中剩下元素 1 到 k-1（在栈中，顺序为 k-1, k-2, ..., 1）
     *
     * 还有元素 k+1 到 i 尚未入栈
     *
     * 现在问题被分解为两个独立的子问题：
     *
     * 左侧部分：元素 1 到 k-1 的出栈顺序
     *
     * 数量为 dp[k-1]
     *
     * 右侧部分：元素 k+1 到 i 的出栈顺序
     *
     * 这些元素将按照顺序入栈，然后出栈
     *
     * 数量为 dp[i-k]
     *
     * 由于这两个部分是独立的，且 k可以是 1 到 i 中的任意值，我们得到状态转移方程：
     *
     * @param n
     * @return
     */
    public int catalanDP(int n) {
        if (n <= 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; // 基础情况

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            // 根据第一个出栈的元素k进行划分
            for (int k = 1; k <= i; k++) {
                // 左侧部分：k-1个元素（1到k-1）
                // 右侧部分：i-k个元素（k+1到i）
                dp[i] += dp[k - 1] * dp[i - k];
            }
        }

        return dp[n];
    }
}

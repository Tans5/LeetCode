package com.leetcode.practice.solutions.dynamicprograming;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class Solution337 {

    public int rob(TreeNode root) {
        Map<TreeNode, int[]> memory = new HashMap<>();
        return backtracking(root, true, memory);
    }

    private int backtracking(TreeNode root, boolean canRobRoot, Map<TreeNode, int[]> memory) {
        if (root == null) {
            return 0 ;
        }
        int[] history = memory.get(root);
        if (history != null) {
            int v;
            if (canRobRoot) {
                v = history[0];
            } else {
                v = history[1];
            }
            if (v != -1) {
                return v;
            }
        } else {
            history = new int[] {-1, -1};
            memory.put(root, history);
        }
        if (canRobRoot) {
            // 两种选择：打劫当前的 root 节点或者不打劫当前的 root 节点
            // 打劫当前节点
            int value1 = root.val;
            value1 += backtracking(root.left, false, memory);
            value1 += backtracking(root.right, false, memory);

            // 不打劫当前节点
            int value2 = backtracking(root.left, true, memory);
            value2 += backtracking(root.right, true, memory);
            int value = Math.max(value1, value2);
            history[0] = value;
            return value;
        } else {
            // 无法打劫当前节点
            int value = backtracking(root.left, true, memory) + backtracking(root.right, true, memory);
            history[1] = value;
            return value;
        }
    }
}

package com.leetcode.practice.solutions.dynamicprograming;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution337_2 {

    public int rob(TreeNode root) {
        int[] result = dfsRob(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 0: 不打劫当前节点的最大收益
     * 1: 打劫当前节点的最大收益
     */
    private int[] dfsRob(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] leftRob = dfsRob(root.left);
        int[] rightRob = dfsRob(root.right);
        int rob = root.val + leftRob[0] + rightRob[0];
        int notRob = Math.max(leftRob[0], leftRob[1]) + Math.max(rightRob[0], rightRob[1]);
        return new int[] {notRob, rob};
    }
}

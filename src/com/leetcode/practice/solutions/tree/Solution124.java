package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        // 用一个数组存储全局最大值（引用传递）
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        // 递归获取左右子树的最大单路径和（如果是负数则取0）
        int leftSum = Math.max(0, maxPathSumHelper(node.left, maxSum));
        int rightSum = Math.max(0, maxPathSumHelper(node.right, maxSum));

        // 计算当前节点的三种路径组合：
        // 1. 独立路径（不向上传递）
        int currentPath = node.val + leftSum + rightSum;

        // 2. 可向上传递的单路径（当前节点+左/右子树）
        int returnPath = node.val + Math.max(leftSum, rightSum);

        // 更新全局最大值
        maxSum[0] = Math.max(maxSum[0], currentPath);

        return returnPath;
    }
}

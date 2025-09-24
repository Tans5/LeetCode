package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // 如果左右子树高度相等，说明是满二叉树
        if (leftHeight == rightHeight) {
            // 使用位运算计算2^h - 1
            return (1 << leftHeight) - 1;
        } else {
            // 否则递归计算左右子树节点数
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // 计算左子树高度（沿左路径）
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // 计算右子树高度（沿右路径）
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}

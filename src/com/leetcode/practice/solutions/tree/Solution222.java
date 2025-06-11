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
        int[] leftResult = calculateTreeDepth(root.left);
        int[] rightResult = calculateTreeDepth(root.right);
        int count = 1;
        if (leftResult[1] == 1) {
            count += (1 << leftResult[0]) - 1;
        } else {
            count += countNodes(root.left);
        }
        if (rightResult[1] == 1) {
            count += (1 << rightResult[0]) - 1;
        } else {
            count += countNodes(root.right);
        }
        return count;
    }


    // 0: 二叉树的深度，1: 是否是满二叉树
    public int[] calculateTreeDepth(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            result[1] = 1;
            return result;
        }
        TreeNode leftCursor = root;
        int leftDepth = 0;
        while (leftCursor != null) {
            leftDepth ++;
            leftCursor = leftCursor.left;
        }
        TreeNode rightCursor = root;
        int rightDepth = 0;
        while (rightCursor != null) {
            rightDepth ++;
            rightCursor = rightCursor.right;
        }
        result[0] = leftDepth;
        result[1] = leftDepth == rightDepth ? 1 : 0;
        return result;
    }
}

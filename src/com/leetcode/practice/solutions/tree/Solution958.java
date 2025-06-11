package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
 *
 * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
 */
public class Solution958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] leftResult = calculateTreeDepth(root.left);
        int[] rightResult = calculateTreeDepth(root.right);
        // 如果左右子树都不是满二叉树，那么当前树一定不是完全二叉树
        if (leftResult[1] != 1 && rightResult[1] != 1) {
            return false;
        }
        // 如果左子树是满二叉树，右子树不是满二叉树
        if (leftResult[1] == 1 && rightResult[1] != 1) {
            // 左右子树深度必须相等才有可能是完全二叉树
            if (leftResult[0] == rightResult[0]) {
                return isCompleteTree(root.right);
            } else {
                return false;
            }
        }
        // 如果左子树不是满二叉树，右子树是满二叉树
        if (leftResult[1] != 1 && rightResult[1] == 1) {
            // 左子树的深度一定比右子树大 1 才有可能是完全二叉树
            if (leftResult[0] - rightResult[0] == 1) {
                return isCompleteTree(root.left);
            } else {
                return false;
            }
        }
        // 如果左右子树都是满二叉树
        if (leftResult[1] == 1 && rightResult[1] == 1) {
            // 左子树的深度比右子树最多大 1 一定是完全二叉树。
            return leftResult[0] >= rightResult[0] && leftResult[0] - rightResult[0] <= 1;
        }
        return true;
    }


    // 0: 二叉树的深度，1: 是否是满二叉树
    public int[] calculateTreeDepth(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            result[1] = 1;
            return result;
        }
        int[] leftResult = calculateTreeDepth(root.left);
        int[] rightResult = calculateTreeDepth(root.right);
        result[0] = 1 + Math.max(leftResult[0], rightResult[0]);
        result[1] = leftResult[1] == 1 && rightResult[1] == 1 && leftResult[0] == rightResult[0] ? 1 : 0;
        return result;
    }
}

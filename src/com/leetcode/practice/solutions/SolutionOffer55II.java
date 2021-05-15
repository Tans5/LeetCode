package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class SolutionOffer55II {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root, 1);
    }

    public boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            return true;
        }
        int leftDepth = depth;
        int rightDepth = depth;
        if (root.left != null) {
            leftDepth = getDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            rightDepth = getDepth(root.right, depth + 1);
        }
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return isBalanced(root.left, depth + 1) && isBalanced(root.right, depth + 1);
        } else {
            return false;
        }
    }
    public int getDepth(TreeNode root, int depth) {
        int res = depth;
        if (root.left == null && root.right == null) {
            return res;
        }

        if (root.left != null) {
            res = getDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            res = Math.max(res, getDepth(root.right, depth + 1));
        }
        return res;
    }
}

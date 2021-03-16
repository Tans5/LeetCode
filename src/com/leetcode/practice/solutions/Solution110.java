package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(treeDeep(root.left) - treeDeep(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    int treeDeep(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(treeDeep(root.left), treeDeep(root.right));
        }
    }
}

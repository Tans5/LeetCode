package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return root;
            } else {
                return null;
            }
        } else {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val != 1) {
                return null;
            }
        }
        return root;
    }
}

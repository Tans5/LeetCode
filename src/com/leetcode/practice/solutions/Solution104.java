package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
          return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return 1 + maxDepth(root.left);
        } else if (root.left == null && root.right != null) {
            return 1 + maxDepth(root.right);
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}

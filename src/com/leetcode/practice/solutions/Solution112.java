package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return scanTree(root, 0, targetSum);
    }

    public boolean scanTree(TreeNode tree, int mySum, int targetSum) {
        if (tree == null) {
            return false;
        }
        mySum += tree.val;
        if (mySum == targetSum && tree.left == null && tree.right == null) {
            return true;
        }
        boolean isFind = scanTree(tree.left, mySum, targetSum);
        if (isFind) {
            return true;
        }
        return scanTree(tree.right, mySum, targetSum);
    }
}

package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        convertTreeValues(root, 0);
        return root;
    }

    public int convertTreeValues(TreeNode tree, int rightSumValue) {
        int result = 0;
        if (tree == null) {
            return result;
        }
        int rightValue = convertTreeValues(tree.right, rightSumValue);
        result += rightValue + tree.val;
        int leftValue = convertTreeValues(tree.left, rightSumValue + tree.val + rightValue);
        result += leftValue;
        tree.val = rightSumValue + rightValue + tree.val;
        return result;
    }

}

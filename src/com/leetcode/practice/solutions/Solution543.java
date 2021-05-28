package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = getTreeDeep(root.left, 0);
        int rightDeep = getTreeDeep(root.right, 0);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(leftDiameter, Math.max(rightDiameter, leftDeep + rightDeep));
    }

    public int getTreeDeep(TreeNode root, int countedDeep) {
        if (root == null) {
            return countedDeep;
        }
        return Math.max(getTreeDeep(root.left, countedDeep + 1), getTreeDeep(root.right, countedDeep + 1));

    }

}

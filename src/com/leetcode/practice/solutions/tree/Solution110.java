package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，判断它是否是 平衡二叉树
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> treeDepth = new HashMap<>();
        return isBalanced(root, treeDepth);
    }

    private boolean isBalanced(TreeNode root,  Map<TreeNode, Integer> history) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        int leftDepth = treeDepth(root.left, history);
        int rightDepth = treeDepth(root.right, history);
        return Math.abs(leftDepth - rightDepth) <= 1;
    }

    private int treeDepth(TreeNode root, Map<TreeNode, Integer> history) {
        if (root == null) {
            return 0;
        }
        Integer h = history.get(root);
        if (h != null) {
            return h;
        } else {
            int leftDepth = treeDepth(root.left, history);
            int rightDepth = treeDepth(root.right, history);
            int d = Math.max(leftDepth, rightDepth) + 1;
            history.put(root, d);
            return d;
        }
    }
}

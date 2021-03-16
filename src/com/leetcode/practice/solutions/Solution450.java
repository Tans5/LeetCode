package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode result = root.right;
                findLastLeftNode(result).left = root.left;
                return result;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            root.left = deleteNode(root.left, key);
            return root;
        }
    }

    public TreeNode findLastLeftNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        } else {
            return findLastLeftNode(root.left);
        }
    }
}

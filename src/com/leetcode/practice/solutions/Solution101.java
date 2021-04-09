package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;


public class Solution101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

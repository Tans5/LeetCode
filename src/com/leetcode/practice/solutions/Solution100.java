package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && p == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (!isSameTree(p.left, q.left)) {
                    return false;
                } else {
                    return isSameTree(p.right, q.right);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

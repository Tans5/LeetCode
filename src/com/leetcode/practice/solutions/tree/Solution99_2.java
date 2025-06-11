package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution99_2 {

    public void recoverTree(TreeNode root) {
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode cursor = root;
        Deque<TreeNode> route = new ArrayDeque<>();
        TreeNode a = null;
        TreeNode b = null;
        while (cursor != null || !route.isEmpty()) {
            if (cursor != null) {
                TreeNode n = cursor;
                while (n != null) {
                    route.push(n);
                    n = n.left;
                }
            }
            TreeNode n = route.pop();
            if (a == null && n.val < prev.val) {
                a = prev;
            }
            if (a != null && n.val < prev.val) {
                b = n;
            }
            prev = n;
            cursor = n.right;
        }
        if (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}

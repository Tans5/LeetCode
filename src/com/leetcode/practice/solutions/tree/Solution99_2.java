package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution99_2 {

    public void recoverTree(TreeNode root) {
        // 1, 2, 3, 4, 5  -> 1, 2, 5, 4, 3

        // 中序遍历，正常一定是升序排列，如果有两个节点发生交换，如上。
        Deque<TreeNode> nodes = new LinkedList<>();
        TreeNode cursor = root;
        // 添加 left 的树节点到栈
        while (cursor != null) {
            nodes.push(cursor);
            cursor = cursor.left;
        }

        TreeNode a = null;
        TreeNode b = null;
        TreeNode previous = null;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (previous != null && a == null && node.val < previous.val) {
                a = previous;
            }
            if (previous != null && a != null && node.val < previous.val) {
                b = node;
            }
            cursor = node.right;
            while (cursor != null) {
                nodes.push(cursor);
                cursor = cursor.left;
            }
            previous = node;
        }
        if (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}

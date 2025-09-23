package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Dfs {


    // 先序遍历
    public List<Integer> dfsPreorder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> dfsDeque = new LinkedList<>();
        dfsDeque.push(root);
        while (!dfsDeque.isEmpty()) {
            TreeNode n = dfsDeque.pop();
            result.add(n.val);
            if (n.right != null) {
                dfsDeque.push(n.right);
            }
            if (n.left != null) {
                dfsDeque.push(n.left);
            }
        }
        return result;
    }

    // 中序遍历
    public List<Integer> dfsInorder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> dfsDeque = new LinkedList<>();
        TreeNode n = root;
        while (n != null) {
            dfsDeque.push(n);
            n = n.left;
        }
        while (!dfsDeque.isEmpty()) {
            n = dfsDeque.pop();
            result.add(n.val);
            n = n.right;
            while (n != null) {
                dfsDeque.push(n);
                n = n.left;
            }
        }
        return result;
    }

    // 后序遍历
    public List<Integer> dfsPostorder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> dfsDeque = new LinkedList<>();
        dfsDeque.push(root);
        while (!dfsDeque.isEmpty()) {
            TreeNode n = dfsDeque.pop();
            result.add(0, n.val);
            if (n.left != null) {
                dfsDeque.push(n.left);
            }
            if (n.right != null) {
                dfsDeque.push(n.right);
            }
        }
        return result;
    }
}

package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Bfs {

    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            result.add(n.val);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        return result;
    }
}

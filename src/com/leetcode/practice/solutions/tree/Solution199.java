package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> front = new ArrayList<>();
        front.add(root);
        List<TreeNode> back = new ArrayList<>();
        int deep = 0;
        while (!front.isEmpty()) {
            deep ++;
            result.add(0);
            for (int i = 0; i < front.size(); i ++) {
                TreeNode n = front.get(i);
                result.set(deep - 1, n.val);
                if (n.left != null) {
                    back.add(n.left);
                }
                if (n.right != null) {
                    back.add(n.right);
                }
            }
            List<TreeNode> temp = front;
            front = back;
            back = temp;
            back.clear();
        }
        return result;
    }
}

package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode tree, List<Integer> result) {
        if (tree == null) {
            return;
        }
        result.add(tree.val);
        preorder(tree.left, result);
        preorder(tree.right, result);
    }
}

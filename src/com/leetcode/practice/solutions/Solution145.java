package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode tree, List<Integer> result) {
        if (tree == null) {
            return;
        }
        postorder(tree.left, result);
        postorder(tree.right, result);
        result.add(tree.val);
    }
}

package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        scanTree(root, result);
        return result;
    }

    public void scanTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        scanTree(root.left, result);
        result.add(root.val);
        scanTree(root.right, result);
    }

}

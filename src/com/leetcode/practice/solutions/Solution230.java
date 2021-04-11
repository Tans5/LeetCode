package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        return scanTree(root, k, new ArrayList<>());
    }
    public Integer scanTree(TreeNode root, int k, List<Integer> history) {
        if (root == null) {
            return null;
        }
        Integer leftResult = scanTree(root.left, k, history);
        if (leftResult != null) {
            return leftResult;
        }
        history.add(root.val);
        if (history.size() == k) {
            return history.get(k - 1);
        }
        return scanTree(root.right, k, history);

    }
}

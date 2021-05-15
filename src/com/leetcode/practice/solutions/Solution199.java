package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            insertResult(root, 1, result);
        }
        return result;
    }

    public void insertResult(TreeNode root, int deep, List<Integer> result) {
        if (deep > result.size()) {
            result.add(root.val);
        }
        if (root.right != null) {
            insertResult(root.right, deep + 1, result);
        }
        if (root.left != null) {
            insertResult(root.left, deep + 1, result);
        }
    }

}

package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findResult(root, 0, result);
        return result;
    }

    public void findResult(TreeNode root, int deep, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (deep == result.size()) {
            List<Integer> newL = new ArrayList<>();
            newL.add(root.val);
            result.add(newL);
        } else {
            result.get(deep).add(root.val);
        }
        findResult(root.left, deep + 1, result);
        findResult(root.right, deep + 1, result);
    }
}

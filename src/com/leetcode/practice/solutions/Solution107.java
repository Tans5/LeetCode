package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        scanTree(root, result, 0);
        for (int i = 0; i < result.size() / 2; i ++) {
            int postIndex = result.size() - 1 - i;
            List<Integer> temp = result.get(i);
            result.set(i, result.get(postIndex));
            result.set(postIndex, temp);
        }
        return result;
    }

    private void scanTree(TreeNode tree, List<List<Integer>> result, int level) {
        if (tree == null) {
            return;
        }
        List<Integer> levelResult;
        if (level >= result.size()) {
            levelResult = new ArrayList<>();
            result.add(levelResult);
        } else {
            levelResult = result.get(level);
        }
        levelResult.add(tree.val);
        scanTree(tree.left, result, level + 1);
        scanTree(tree.right, result, level + 1);
    }
}

package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        scanTree(root, result, 0);
        for (int i = 1; i < result.size(); i = i + 2) {
            List<Integer> needRevers = result.get(i);
            for (int j = 0; j < needRevers.size() / 2; j ++) {
                Integer temp = needRevers.get(j);
                int postIndex = needRevers.size() - j - 1;
                needRevers.set(j, needRevers.get(postIndex));
                needRevers.set(postIndex, temp);
            }
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

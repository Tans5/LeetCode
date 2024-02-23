package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (k <= 0) {
            return - 1;
        }
        List<Long> levelSum = new ArrayList<>();
        scanTree(root, levelSum, 0);
        if (k > levelSum.size()) {
            return -1;
        }
        Object[] array = levelSum.toArray();
        Arrays.sort(array);
        return (Long) array[array.length - k];
    }

    private void scanTree(TreeNode tree, List<Long> levelSum, int level) {
        if (tree == null) {
            return;
        }
        long lastSum;
        if (levelSum.size() <= level) {
            lastSum = 0;
            levelSum.add(lastSum);
        } else {
            lastSum = levelSum.get(level);
        }
        lastSum += tree.val;
        levelSum.set(level, lastSum);
        scanTree(tree.left, levelSum, level + 1);
        scanTree(tree.right, levelSum, level + 1);
    }
}

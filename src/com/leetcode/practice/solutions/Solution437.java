package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class Solution437 {

//    private int targetCount = 0;

//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return 0;
//        }
//        targetCount = 0;
//        scanTree(root, (long) targetSum);
//        return targetCount;
//    }

//    void scanTree(TreeNode tree, long targetSum) {
//        if (tree == null) {
//            return;
//        }
//        count(tree, targetSum);
//        scanTree(tree.left, targetSum);
//        scanTree(tree.right, targetSum);
//    }
//
//    void count(TreeNode node, long target) {
//        if (node == null) {
//            return;
//        }
//        if (node.val == target) {
//            targetCount ++;
//        }
//        count(node.left, target - node.val);
//        count(node.right, target - node.val);
//    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}

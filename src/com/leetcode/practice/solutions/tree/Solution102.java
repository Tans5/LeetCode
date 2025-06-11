package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(root, result, 0);
        return result;
    }

    private void level(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        List<Integer> levelResult;
        if (level >= result.size()) {
            levelResult = new ArrayList<>();
            result.add(levelResult);
        } else {
            levelResult = result.get(level);
        }
        levelResult.add(root.val);
        level(root.left, result, level + 1);
        level(root.right, result, level + 1);
    }
}

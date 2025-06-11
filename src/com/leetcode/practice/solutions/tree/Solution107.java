package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(root, result, 0);
        List<Integer> temp;
        for (int i = 0; i < result.size() / 2; i ++) {
            temp = result.get(i);
            result.set(i, result.get(result.size() - i - 1));
            result.set(result.size() - i - 1, temp);
        }
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

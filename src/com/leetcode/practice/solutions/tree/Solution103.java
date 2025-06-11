package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(root, result, 0);
        for (int i = 1; i < result.size(); i += 2) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size() / 2; j ++) {
                int temp = list.get(j);
                list.set(j, list.get(list.size() - j - 1));
                list.set(list.size() - j - 1, temp);
            }
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

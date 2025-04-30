package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<TreeNode>> nodesLevels = new ArrayList<>();
        scanNode(root, nodesLevels, 1);
        List<Double> result = new ArrayList<>();
        for (List<TreeNode> nodes: nodesLevels) {
            double sum = 0.0;
            for (TreeNode n: nodes) {
                sum += n.val;
            }
            result.add(sum / nodes.size());
        }
        return result;
    }

    void scanNode(TreeNode n, List<List<TreeNode>> nodesLevels, int level) {
        if (n == null) {
            return;
        }
        List<TreeNode> levelNode;
        if (level > nodesLevels.size()) {
            levelNode = new ArrayList<>();
            nodesLevels.add(levelNode);
        } else {
            levelNode = nodesLevels.get(level - 1);
        }
        levelNode.add(n);
        scanNode(n.left, nodesLevels,level + 1);
        scanNode(n.right, nodesLevels, level + 1);
    }
}

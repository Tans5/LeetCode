package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {

    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        buildNodes(root, nodes);
        for (int i = 0; i < nodes.size() - 1; i ++) {
            TreeNode node = nodes.get(i);
            node.left = null;
            node.right = nodes.get(i + 1);
        }
    }

    public void buildNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        buildNodes(root.left, nodes);
        buildNodes(root.right, nodes);
    }

}

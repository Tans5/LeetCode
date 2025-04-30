package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> treeLevels = new ArrayList<>();
        scanTreeLevels(root, treeLevels, 1);
        return root;
    }

    private void scanTreeLevels(Node node, List<List<Node>> treeLevels, int level) {
        if (node == null) {
            return;
        }
        List<Node> currentLevelNodes;
        if (level > treeLevels.size()) {
            currentLevelNodes = new ArrayList<>();
            treeLevels.add(currentLevelNodes);
        } else {
            currentLevelNodes = treeLevels.get(level - 1);
        }
        if (currentLevelNodes.size() >= 1) {
            currentLevelNodes.get(currentLevelNodes.size() - 1).next = node;
        }
        currentLevelNodes.add(node);
        scanTreeLevels(node.left, treeLevels, level + 1);
        scanTreeLevels(node.right, treeLevels, level + 1);
    }

    public static class Node {
        int val;
        Node left = null;
        Node right = null;
        Node next = null;
    }
}

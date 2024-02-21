package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        scanNode(root, result, 0);
        return result;
    }

    private void scanNode(Node node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        List<Integer> levelResult;
        if (result.size() <= level) {
            levelResult = new ArrayList<>();
            result.add(levelResult);
        } else {
            levelResult = result.get(level);
        }
        levelResult.add(node.val);
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                scanNode(child, result, level + 1);
            }
        }
    }
}

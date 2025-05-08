package com.leetcode.practice.solutions.divideandconquer;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private TreeNode createTreeNode(int v) {
        TreeNode n = new TreeNode();
        n.val = v;
        return n;
    }

    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> result = new ArrayList<>();
        if (from > to) {
            return result;
        } else if (from == to) {
            result.add(createTreeNode(from));
            return result;
        } else {
            for (int i = from; i <= to; i ++) {
                // leftChild
                List<TreeNode> leftChild = generateTrees(from, i - 1);
                // rightChild
                List<TreeNode> rightChild = generateTrees(i + 1, to);
                if (leftChild.isEmpty() && rightChild.isEmpty()) {
                    result.add(createTreeNode(i));
                } else if (!leftChild.isEmpty() && !rightChild.isEmpty()) {
                    for (TreeNode lc: leftChild) {
                        for (TreeNode rc: rightChild) {
                            TreeNode n = createTreeNode(i);
                            n.left = lc;
                            n.right = rc;
                            result.add(n);
                        }
                    }
                } else if (rightChild.isEmpty()) {
                    for (TreeNode lc: leftChild) {
                        TreeNode n = createTreeNode(i);
                        n.left = lc;
                        result.add(n);
                    }
                } else {
                    for (TreeNode rc: rightChild) {
                        TreeNode n = createTreeNode(i);
                        n.right = rc;
                        result.add(n);
                    }
                }
            }
            return result;
        }
    }
}

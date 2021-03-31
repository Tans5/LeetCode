package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution173 {
}

class BSTIterator {

    List<Integer> data = new ArrayList<>();
    int nextIndex = 0;

    public BSTIterator(TreeNode root) {
        scanTree(root);
    }

    private void scanTree(TreeNode tree) {
        if (tree != null) {
            scanTree(tree.left);
            data.add(tree.val);
            scanTree(tree.right);
        }
    }

    public int next() {
        return data.get(nextIndex ++);
    }

    public boolean hasNext() {
        return data.size() > nextIndex;
    }
}
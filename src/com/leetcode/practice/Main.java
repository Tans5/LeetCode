package com.leetcode.practice;


import com.leetcode.practice.solutions.others.TreeNode;
import com.leetcode.practice.solutions.tree.Solution1382;

public class Main {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree(
                new int[] {1, 15, 14, 7, 2, 3, 12, 9, 11, 17},
                new int[] {1, 2, 3, 7, 9, 11, 12, 14, 15, 17});
        Solution1382 s = new Solution1382();
        node = s.balanceBST(node);
        TreeNode.printTree(node);
    }
}

package com.leetcode.practice;

import com.leetcode.practice.solutions.Solution101;
import com.leetcode.practice.solutions.others.TreeNode;


public class Main {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(2);
        System.out.println(Solution101.isSymmetric(tree));
    }
}

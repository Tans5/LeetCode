package com.leetcode.practice;

import com.leetcode.practice.solutions.Solution236;
import com.leetcode.practice.solutions.others.TreeNode;


public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(Solution236.lowestCommonAncestor(root, root.left, root.right).val);
    }
}

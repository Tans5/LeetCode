package com.leetcode.practice;


import com.leetcode.practice.solutions.divideandconquer.Solution95;
import com.leetcode.practice.solutions.others.TreeNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution95 s = new Solution95();
        List<TreeNode> result = s.generateTrees(4);
        for(TreeNode tree: result) {
            System.out.println("-------------");
            TreeNode.printTree(tree);
            System.out.println("-------------");
        }
    }
}

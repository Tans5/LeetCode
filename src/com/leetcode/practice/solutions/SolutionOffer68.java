package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class SolutionOffer68 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p.val > root.val && q.val < root.val) {
            return root;
        }
        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }

}

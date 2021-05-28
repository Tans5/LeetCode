package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

public class Solution617 {

    public TreeNode mergeTrees(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode result = new TreeNode();
        if (root1 == null) {
            result.val = root2.val;
            result.left = mergeTrees(null, root2.left);
            result.right = mergeTrees(null, root2.right);
            return result;
        }
        if (root2 == null) {
            result.val = root1.val;
            result.left = mergeTrees(null, root1.left);
            result.right = mergeTrees(null, root1.right);
            return result;
        }
        result.val = root1.val + root2.val;
        result.left = mergeTrees(root1.left, root2.left);
        result.right = mergeTrees(root1.right, root2.right);
        return result;
    }

}

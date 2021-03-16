package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE, new ArrayList<>());
    }

    public boolean isValidBST(TreeNode root, int max, int min, List<Integer> history) {
        if (root == null) {
            return true;
        }
        if (history.contains(root.val)) {
            return false;
        }
        history.add(root.val);
        if (root.left == null && root.right == null) {
            return (root.val < max || max == Integer.MAX_VALUE) && (root.val > min || min == Integer.MIN_VALUE);
        }
        if (root.left != null && root.right != null) {
            if (root.left.val < root.val && root.val < root.right.val && (root.val < max || max == Integer.MAX_VALUE) && (root.val > min || min == Integer.MIN_VALUE)) {
                return isValidBST(root.left, root.val, min, history) && isValidBST(root.right, max, root.val, history);
            } else {
                return false;
            }
        } else if (root.left == null) {
            if (root.val < root.right.val && (root.val < max || max == Integer.MAX_VALUE) && (root.val > min || min == Integer.MIN_VALUE)) {
                return isValidBST(root.right, max, root.val, history);
            } else {
                return false;
            }
        } else {
            if (root.left.val < root.val && (root.val < max || max == Integer.MAX_VALUE) && (root.val > min || min == Integer.MIN_VALUE)) {
                return isValidBST(root.left, root.val, min, history);
            } else {
                return false;
            }
        }
    }
}

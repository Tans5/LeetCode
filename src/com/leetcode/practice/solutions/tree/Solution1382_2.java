package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1382_2 {

    class Solution {
        public TreeNode balanceBST(TreeNode root) {
            // 1. 中序遍历获取有序数组
            List<Integer> sorted = new ArrayList<>();
            inorderTraversal(root, sorted);

            // 2. 将有序数组转换为平衡BST
            return buildBalancedBST(sorted, 0, sorted.size() - 1);
        }

        // 中序遍历收集节点值
        private void inorderTraversal(TreeNode node, List<Integer> list) {
            if (node == null) return;
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }

        // 递归构建平衡BST
        private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
            if (start > end) return null;

            // 选择中间位置作为根节点
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(list.get(mid));

            // 递归构建左右子树
            root.left = buildBalancedBST(list, start, mid - 1);
            root.right = buildBalancedBST(list, mid + 1, end);

            return root;
        }
    }
}

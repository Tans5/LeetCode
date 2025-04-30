package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class Solution1382 {

    public TreeNode balanceBST(TreeNode root) {
        Map<TreeNode, Integer> nodesHeight = new HashMap<>();
        return balance(root, nodesHeight);
    }

    private TreeNode balance(TreeNode root, Map<TreeNode, Integer> nodesHeight) {
        if (root == null) {
            return null;
        }
        root.left = balance(root.left, nodesHeight);
        root.right = balance(root.right, nodesHeight);
        nodesHeight.put(root, calculateTreeHeight(root));
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode result = root;
        int balanceFactor = nodesHeight.getOrDefault(left, 0) - nodesHeight.getOrDefault(right, 0);
        if (balanceFactor > 1) {
            // 左边高
            int leftBalanceFactor = nodesHeight.getOrDefault(left.left, 0) - nodesHeight.getOrDefault(left.right, 0);
            if (leftBalanceFactor >= 0) {
                /**
                 * Step1:
                 *        3
                 *       /
                 *      2
                 *     /
                 *    1
                 *
                 * Step2:
                 *       2
                 *      / \
                 *     1  3
                 */

                result = balance(routeRight(root, nodesHeight), nodesHeight);
            } else {
                /**
                 * Step1:
                 *       3
                 *      /
                 *     2
                 *      \
                 *      2.5
                 *
                 * Step2:
                 *      3
                 *     /
                 *   2.5
                 *   /
                 *  2
                 *
                 * Step3:
                 *      2.5
                 *      / \
                 *     2   3
                 */
                root.left = routeLeft(left, nodesHeight);
                result = balance(routeRight(root, nodesHeight), nodesHeight);
            }
            nodesHeight.put(result, calculateTreeHeight(result));
        } else if (balanceFactor < -1) {
            // 右边高
            int rightBalanceFactor = nodesHeight.getOrDefault(right.left, 0) - nodesHeight.getOrDefault(right.right, 0);
            if (rightBalanceFactor <= 0) {
                /**
                 * Step1:
                 *   1
                 *    \
                 *     2
                 *      \
                 *       3
                 * Step2:
                 *   2
                 *  / \
                 * 1   3
                 */
                result = balance(routeLeft(root, nodesHeight), nodesHeight);
            } else {
                /**
                 * Step1:
                 *    1
                 *     \
                 *      2
                 *     /
                 *    1.5
                 *
                 * Step2:
                 *    1
                 *     \
                 *     1.5
                 *       \
                 *        2
                 *
                 * Step3:
                 *    1.5
                 *    / \
                 *   1   2
                 */
                root.right = routeRight(right, nodesHeight);
                result = balance(routeLeft(root, nodesHeight), nodesHeight);
            }
            nodesHeight.put(result, calculateTreeHeight(result));
        }

        return result;
    }

    private int calculateTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(calculateTreeHeight(root.left), calculateTreeHeight(root.right)) + 1;
    }

    /**
     *        3
     *       / \
     *      2   4
     *     / \
     *    1  2.5
     *   /
     *  0
     *
     *       2
     *      / \
     *     1   3
     *    /   / \
     *   0  2.5  4
     *
     */
    private TreeNode routeRight(TreeNode root, Map<TreeNode, Integer> nodesHeight) {
        if (root == null) {
            return null;
        }
        TreeNode result = root.left;
        root.left = result.right;
        result.right = root;
        nodesHeight.put(root, calculateTreeHeight(root));
        nodesHeight.put(result, calculateTreeHeight(result));
        return result;
    }


    /**
     *    2
     *   / \
     *  1   3
     *     / \
     *   2.5  4
     *         \
     *          5
     *
     *      3
     *     / \
     *    2   4
     *   / \   \
     *  1  2.5  5
     */
    private TreeNode routeLeft(TreeNode root,  Map<TreeNode, Integer> nodesHeight) {
        if (root == null) {
            return null;
        }
        TreeNode result = root.right;
        root.right = result.left;
        result.left = root;
        nodesHeight.put(root, calculateTreeHeight(root));
        nodesHeight.put(result, calculateTreeHeight(result));
        return result;
    }
}

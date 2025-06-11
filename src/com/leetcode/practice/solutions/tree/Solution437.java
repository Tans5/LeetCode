package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class Solution437 {

    /**
     * 树可以理解成多个链表，根到不同的叶节点就是一个链表，该问题简化成一个链表中路径和等于目标值。
     * 假如有如下链表：
     * A -> B -> C -> D -> E -> F -> G
     * 假设 Sum(E, G) 为目标值 target。
     * 那么 Sum(E, G) = Sum(A, G) - Sum(A, D)
     */
    public int pathSum(TreeNode root, int targetSum) {
        // Key: Root当前节点的和，Value：当前和出现的次数
        Map<Long, Integer> sumRecords = new HashMap<>();
        sumRecords.put(0L, 1);
        return scanTree(root, 0L, targetSum, sumRecords);
    }

    private int scanTree(TreeNode root, long sum, long targetSum, Map<Long, Integer> sumRecords) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int count = sumRecords.getOrDefault(sum - targetSum, 0);
        sumRecords.put(sum, sumRecords.getOrDefault(sum, 0) + 1);
        count += scanTree(root.left, sum, targetSum, sumRecords);
        count += scanTree(root.right, sum, targetSum, sumRecords);
        sumRecords.put(sum, sumRecords.getOrDefault(sum, 0) - 1);
        return count;
    }
}

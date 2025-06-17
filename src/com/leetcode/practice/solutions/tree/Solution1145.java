package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

/**
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
 *
 * 最开始时：
 *
 * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
 * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
 * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
 *
 * 之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
 *
 * 如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
 *
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 *
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。
 */
public class Solution1145 {

    /**
     * 玩家 1 初始化选者 x 节点后，将原本的树的区域分成 3 部分，分别是： x 的左子树、x 的右子树、x 的父节点及其 x 的兄弟子树。
     * 玩家 2 可以选择占领上面 3 个区域之一而不让玩家 1 占领，对应的占领上面区域的方法是：占领 x 的左子树、占领 x 的右子树，占领 x 的父节点。
     * 所以玩家 2 想要赢，上面的三个区域的节点树必须大于 n / 2 才能够赢。
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }
        TreeNode xNode = findNode(root, x);
        if (xNode == null) {
            return false;
        }
        int leftCount = countNode(xNode.left);
        int rightCount = countNode(xNode.right);
        int parentCount = n - leftCount - rightCount - 1;
        int max = Math.max(Math.max(leftCount, rightCount), parentCount);
        return max > n / 2;
    }

    TreeNode findNode(TreeNode root, int v) {
        if (root == null) {
            return null;
        }
        if (root.val == v) {
            return root;
        }
        TreeNode result = findNode(root.left, v);
        if (result != null) {
            return result;
        }
        return findNode(root.right, v);
    }

    int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
}

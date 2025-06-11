package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 */
public class Solution99 {

    public void recoverTree(TreeNode root) {
        List<TreeNode> scanList = new ArrayList<>();
        scanTree(root, scanList);
        // 找到第一个大于后一个节点的节点的 index
        int aIndex = -1;
        for (int i = 0; i < scanList.size() - 1; i ++) {
            if (scanList.get(i).val > scanList.get(i + 1).val) {
                aIndex = i;
                break;
            }
        }
        if (aIndex == -1) {
            return;
        }

        // 找到最后一个节点小于前一个节点的 index
        int bIndex = -1;
        for (int i = scanList.size() - 1; i > aIndex; i --) {
            if (scanList.get(i).val < scanList.get(i - 1).val) {
                bIndex = i;
                break;
            }
        }
        if (bIndex == -1) {
            return;
        }
        TreeNode a =  scanList.get(aIndex);
        TreeNode b = scanList.get(bIndex);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void scanTree(TreeNode root, List<TreeNode> scanList) {
        if (root == null) {
            return;
        }
        scanTree(root.left, scanList);
        scanList.add(root);
        scanTree(root.right, scanList);
    }

}

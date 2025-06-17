package com.leetcode.practice.solutions.tree;

import com.leetcode.practice.solutions.others.ListNode;
import com.leetcode.practice.solutions.others.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Solution116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> front = new ArrayList<>();
        front.add(root);
        List<Node> back = new ArrayList<>();
        while (!front.isEmpty()) {
            for (int i = 0; i < front.size() - 1; i ++) {
                Node n = front.get(i);
                n.next = front.get(i + 1);
                Node left = n.left;
                Node right = n.right;
                if (left != null && right != null) {
                    back.add(left);
                    back.add(right);
                }
            }
            Node lastNode = front.get(front.size() - 1);
            if (lastNode.left != null && lastNode.right != null) {
                back.add(lastNode.left);
                back.add(lastNode.right);
            }
            List<Node> temp = front;
            front = back;
            back = temp;
            back.clear();
        }
        return root;
    }

    public static class Node {
        int val;
        Node left = null;
        Node right = null;
        Node next = null;
    }
}

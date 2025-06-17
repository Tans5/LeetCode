package com.leetcode.practice.solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class Solution117 {

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
                if (n.left != null) {
                    back.add(n.left);
                }
                if (n.right != null) {
                    back.add(n.right);
                }
            }
            Node lastNode = front.get(front.size() - 1);
            if (lastNode.left != null) {
                back.add(lastNode.left);
            }
            if (lastNode.right != null) {
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

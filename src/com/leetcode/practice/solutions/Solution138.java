package com.leetcode.practice.solutions;


import java.util.HashMap;
import java.util.Map;

public class Solution138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> pNodeToNode = new HashMap<>();

        return copyRandomListLocal(head, pNodeToNode);
    }

    Node copyRandomListLocal(Node pNode, Map<Node, Node> pNodeToRNode) {
        if (pNode == null) {
            return null;
        }
        Node rNode = pNodeToRNode.get(pNode);
        if (rNode == null) {
            rNode = new Node(pNode.val);
            pNodeToRNode.put(pNode, rNode);
            rNode.next = copyRandomListLocal(pNode.next, pNodeToRNode);
            rNode.random = copyRandomListLocal(pNode.random, pNodeToRNode);
        }
        return rNode;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

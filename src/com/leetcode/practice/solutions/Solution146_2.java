package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution146_2 {
    private int capacity;
    private int size = 0;

    private Node head = new Node();
    private Node tail = new Node();

    private Map<Integer, Node> nodeKeyMap = new HashMap<>();

    public Solution146_2(int capacity) {
        this.capacity = capacity;
        size = 0;
        head.next = tail;
        head.pre = tail;
        tail.next = head;
        tail.pre = head;
    }

    public int get(int key) {
        Node n = findNode(key);
        if (n == null) {
            return -1;
        } else {
            moveToHead(n);
            return n.value;
        }
    }

    public void put(int key, int value) {
        Node n = findNode(key);
        if (n != null) {
            n.value = value;
            moveToHead(n);
        } else {
            if (size >= capacity) {
                removeOldestNode();
            } else {
                size ++;
            }
            n = new Node();
            setHead(n);
            n.key = key;
            n.value = value;
            nodeKeyMap.put(key, n);
        }
    }

    private Node findNode(int key) {
        return nodeKeyMap.get(key);
    }

    private void moveToHead(Node n) {
        Node pre = n.pre;
        if (pre == head) {
            return;
        }
        Node next = n.next;
        pre.next = next;
        next.pre = pre;

        next = head.next;
        pre = head;
        n.pre = pre;
        pre.next = n;
        n.next = next;
        next.pre= n;
    }

    private void setHead(Node n) {
        Node next = head.next;
        Node pre = head;
        pre.next = n;
        n.pre = pre;
        n.next = next;
        next.pre = n;
    }

    private void removeOldestNode() {
        Node target = tail.pre;
        if (target == head) {
            return;
        }
        Node pre = target.pre;
        tail.pre = pre;
        pre.next = tail;
        nodeKeyMap.remove(target.key);
    }

    private class Node {
        int key = -1;
        int value = -1;
        Node pre = null;
        Node next = null;
    }
}

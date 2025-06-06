package com.leetcode.practice.solutions.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    private final int capacity;
    private final Node head = new Node();
    private final Map<Integer, Node> map = new HashMap<>();

    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = head;
        head.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            makeHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (size >= capacity) {
                Node toRemove = head.pre;
                if (toRemove != head) {
                    removeNode(toRemove);
                    map.remove(toRemove.key);
                }
            } else {
                size ++;
            }
            node = new Node();
            node.key = key;
            map.put(key, node);
        }
        makeHead(node);
        node.value = value;
    }

    private void makeHead(Node n) {
        removeNode(n);
        Node next = head.next;
        head.next = n;
        n.pre = head;
        next.pre = n;
        n.next = next;
    }

    private void makeTail(Node n) {
        removeNode(n);
        Node pre = head.pre;
        Node next = head;
        n.next = next;
        next.pre = n;
        n.pre = pre;
        pre.next = n;
    }

    private void removeNode(Node n) {
        Node pre = n.pre;
        Node next = n.next;
        n.pre = null;
        n.next = null;
        if (pre != null && next != null) {
            pre.next = next;
            next.pre = pre;
        }
    }

    private static class Node {
        int value;
        int key;
        Node pre = null;
        Node next = null;
    }
}

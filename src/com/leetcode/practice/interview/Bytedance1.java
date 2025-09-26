package com.leetcode.practice.interview;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 需要支持范形和线程安全
 */
public class Bytedance1 {

    public static class LruCache<K, V> {
        private int cap = 1;
        private int size = 0;
        private ReentrantLock lock = new ReentrantLock();
        private HashMap<K, Node> map = new HashMap<>();
        private Node head = new Node();

        public LruCache(int cap) {
            this.cap = cap;
        }

        public V get(K key) {
            V result = null;
            lock.lock();
            Node node = map.get(key);
            if (node != null) {
                result = node.value;
                makeHead(node);
            }
            lock.unlock();
            return result;
        }

        public void put(K key, V value) {
            lock.lock();
            Node cacheNode = map.get(key);
            if (cacheNode != null) {
                cacheNode.value = value;
                makeHead(cacheNode);
            } else {
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                if (size == cap) {
                    Node oldest = head.pre;
                    removeNode(oldest);
                    map.remove(oldest.key);
                    size --;
                }
                makeHead(newNode);
                map.put(key, newNode);
                size ++;
            }
            lock.unlock();
        }

        private void makeHead(Node n) {
            removeNode(n);
            Node next = head.next;
            n.pre = head;
            head.next = n;
            n.next = next;
            next.pre = n;
        }

        private void removeNode(Node n) {
            if (n.pre != n && n.next != n) {
                Node pre = n.pre;
                Node next = n.next;
                n.pre = n;
                n.next = n;
                pre.next = next;
                next.pre = pre;
            }
        }

        class Node {
            K key = null;
            V value = null;
            Node pre = this;
            Node next = this;
        }
    }
}

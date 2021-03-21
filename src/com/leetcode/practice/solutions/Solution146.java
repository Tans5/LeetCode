package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}

class LRUCache {

    private final int capacity;

    private final ArrayBlockingQueue<Integer> keyQueue;
    private final Map<Integer, Integer> data = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        keyQueue = new ArrayBlockingQueue<>(capacity);
    }

    public int get(int key) {
        Integer result = data.get(key);
        if (result == null) {
            return -1;
        } else {
            keyQueue.remove(key);
            keyQueue.add(key);
            return result;
        }
    }

    public void put(int key, int value) {
        if (keyQueue.contains(key)) {
            keyQueue.remove(key);
        } else {
            if (keyQueue.size() >= capacity) {
                data.remove(keyQueue.poll());
            }
        }
        keyQueue.add(key);
        data.put(key, value);
    }

}

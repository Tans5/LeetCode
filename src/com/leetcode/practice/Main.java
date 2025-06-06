package com.leetcode.practice;

import com.leetcode.practice.solutions.linkedlist.LRUCache;
import com.leetcode.practice.solutions.linkedlist.Solution2;
import com.leetcode.practice.solutions.linkedlist.Solution92;
import com.leetcode.practice.solutions.others.ListNode;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
    }
}

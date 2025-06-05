package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            list.add(cursor.val);
            cursor = cursor.next;
        }
        for (int i = 0; i < list.size() / 2; i ++) {
            int a = list.get(i);
            int b = list.get(list.size() - i - 1);
            if (a != b) {
                return false;
            }
        }
        return true;
    }
}

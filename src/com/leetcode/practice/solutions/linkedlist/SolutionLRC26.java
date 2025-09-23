package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;

public class SolutionLRC26 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            list.add(cursor);
            cursor = cursor.next;
        }
        cursor = null;
        for (int i = 0; i < list.size() / 2; i ++) {
            ListNode a = list.get(i);
            a.next = null;
            ListNode b = list.get(list.size() - i - 1);
            b.next = null;
            if (cursor == null) {
                cursor = a;
            } else {
                cursor.next = a;
            }
            a.next = b;
            cursor = b;
        }
        if (list.size() % 2 == 1) {
            ListNode last = list.get(list.size() / 2);
            last.next = null;
            cursor.next = last;
        }
    }
}

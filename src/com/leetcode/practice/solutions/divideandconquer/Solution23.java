package com.leetcode.practice.solutions.divideandconquer;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else {
            ListNode result = lists[0];
            for (int i = 1; i < lists.length; i ++) {
                result = mergeNodes(result, lists[i]);
            }
            return result;
        }
    }

    private ListNode mergeNodes(ListNode a, ListNode b) {
        if (a == null && b != null) {
            return b;
        } else if (a != null && b == null) {
            return a;
        } else if (a == null && b == null) {
            return null;
        }
        ListNode result;
        ListNode cursor;
        ListNode cursorA;
        ListNode cursorB;
        if (a.val <= b.val) {
            result = a;
            cursorA = a.next;
            cursorB = b;
        } else {
            result = b;
            cursorA = a;
            cursorB = b.next;
        }
        cursor = result;
        while (true) {
            if (cursorA == null) {
                cursor.next = cursorB;
                break;
            }
            if (cursorB == null) {
                cursor.next = cursorA;
                break;
            }
            if (cursorA.val <= cursorB.val) {
                cursor.next = cursorA;
                cursor = cursorA;
                cursorA = cursorA.next;
            } else {
                cursor.next = cursorB;
                cursor = cursorB;
                cursorB = cursorB.next;
            }
        }
        return result;
    }
}

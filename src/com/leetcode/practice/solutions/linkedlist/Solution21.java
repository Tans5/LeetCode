package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head;
        ListNode cursor;
        ListNode cursor1;
        ListNode cursor2;
        if (list1.val < list2.val) {
            head = list1;
            cursor1 = list1.next;
            head.next = null;
            cursor = head;
            cursor2 = list2;
        } else {
            head = list2;
            cursor2 = list2.next;
            head.next = null;
            cursor = head;
            cursor1 = list1;
        }
        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val < cursor2.val) {
                cursor.next = cursor1;
                cursor1 = cursor1.next;
            } else {
                cursor.next = cursor2;
                cursor2 = cursor2.next;
            }
            cursor = cursor.next;
            cursor.next = null;
        }
        cursor.next = cursor1 != null ? cursor1 : cursor2;
        return head;
    }
}

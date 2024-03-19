package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;

        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            if (current.val < x) {
                if (smallHead == null) {
                    smallHead = current;
                }
                if (smallTail != null) {
                    smallTail.next = current;
                }
                smallTail = current;
            } else {
                if (bigHead == null) {
                    bigHead = current;
                }
                if (bigTail != null) {
                    bigTail.next = current;
                }
                bigTail = current;
            }
            current.next = null;
            current = next;
            if (current != null) {
                next = current.next;
            } else {
                next = null;
            }
        }
        if (smallHead == null) {
            return bigHead;
        } else {
            smallTail.next = bigHead;
            return smallHead;
        }
    }
}

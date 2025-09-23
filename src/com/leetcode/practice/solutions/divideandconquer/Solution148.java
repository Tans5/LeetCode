package com.leetcode.practice.solutions.divideandconquer;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Solution148 {

    // 归并排序的思想
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slowCursor = head;
        ListNode prefix = null;
        ListNode fastCursor = head;
        while (fastCursor != null && fastCursor.next != null) {
            prefix = slowCursor;
            slowCursor = slowCursor.next;
            fastCursor = fastCursor.next.next;
        }
        ListNode mid = slowCursor;
        prefix.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }
        ListNode result = null;
        ListNode resultCursor = null;
        ListNode leftCursor = left;
        ListNode rightCursor = right;
        while (leftCursor != null && rightCursor != null) {
            ListNode n;
            if (leftCursor.val <= rightCursor.val) {
                n = leftCursor;
                leftCursor = leftCursor.next;
            } else {
                n = rightCursor;
                rightCursor = rightCursor.next;
            }
            n.next = null;
            if (result == null) {
                result = n;
                resultCursor = n;
            } else {
                resultCursor.next = n;
                resultCursor = n;
            }
        }
        resultCursor.next = leftCursor != null ? leftCursor : rightCursor;
        return result;
    }
}

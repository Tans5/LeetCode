package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int listALen = nodeLen(headA);
        int listBLen = nodeLen(headB);
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        if (listALen > listBLen) {
            cursorA = moveLen(headA, listALen - listBLen);
        }
        if (listBLen > listALen) {
            cursorB = moveLen(headB, listBLen - listALen);
        }

        while (cursorA != null) {
            if (cursorA == cursorB) {
                return cursorB;
            } else {
                cursorA = cursorA.next;
                cursorB = cursorB.next;
            }
        }
        return null;
    }

    private int nodeLen(ListNode root) {
        ListNode cursor = root;
        int len = 0;
        while (cursor != null) {
            cursor = cursor.next;
            len ++;
        }
        return len;
    }

    private ListNode moveLen(ListNode root, int moveLen) {
        ListNode cursor = root;
        for (int i = 0; i < moveLen; i ++) {
            if (cursor == null) {
                break;
            }
            cursor = cursor.next;
        }
        return cursor;
    }
}

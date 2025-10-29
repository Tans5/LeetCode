package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        while (cursorA != cursorB) {
            cursorA = cursorA == null ? headA : cursorA.next;
            cursorB = cursorB == null ? headB : cursorB.next;
        }
        return cursorA;
    }
}

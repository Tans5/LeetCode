package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode focusNode = head;
        ListNode l1Focus = l1;
        ListNode l2Focus = l2;
        while (true) {
            if (l1Focus == null) {
                focusNode.next = l2Focus;
                break;
            }
            if (l2Focus == null) {
                focusNode.next = l1Focus;
                break;
            }
            int v1 = l1Focus.val;
            int v2 = l2Focus.val;
            if (v1 <= v2) {
                focusNode.next = l1Focus;
                l1Focus = l1Focus.next;
            } else {
                focusNode.next = l2Focus;
                l2Focus = l2Focus.next;
            }
            focusNode = focusNode.next;
            focusNode.next = null;
        }
        return head.next;
    }
}

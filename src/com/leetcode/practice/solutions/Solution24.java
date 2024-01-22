package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        swapNextNode(head, null);
        ListNode pre = result.next;
        ListNode current = result.next.next;
        while (current != null && current.next != null) {
            swapNextNode(current, pre);
            pre = current;
            current = current.next;
        }
        return result;
    }

    private void swapNextNode(ListNode node, ListNode pre) {
        ListNode next = node.next;
        if (next == null) {
            return;
        }
        node.next = next.next;
        next.next = node;
        if (pre != null) {
            pre.next = next;
        }
    }
}

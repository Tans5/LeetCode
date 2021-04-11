package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode targetNode = head.next;
        newHead.next = null;
        ListNode movingNode;
        ListNode nextNode;
        ListNode tempNode;
        while (targetNode != null) {
            nextNode = targetNode.next;
            movingNode = newHead;
            do {
                if (targetNode.val <= newHead.val) {
                    targetNode.next = newHead;
                    newHead = targetNode;
                    break;
                }
                if (movingNode.next == null) {
                    movingNode.next = targetNode;
                    targetNode.next = null;
                    break;
                }
                if (movingNode.next.val >= targetNode.val) {
                    tempNode = movingNode.next;
                    movingNode.next = targetNode;
                    movingNode.next.next = tempNode;
                    break;
                }
                movingNode = movingNode.next;

            } while (true);
            targetNode = nextNode;
        }

        return newHead;
    }

}

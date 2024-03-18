package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        ListNode singleHead = head;
        int c = 0;
        boolean skipTail = false;
        List<ListNode> nodes = new ArrayList<>();
        while (current != null) {
            pre = current;
            current = next;
            if (current != null) {
                next = current.next;
            } else {
                next = null;
            }
            c ++;
            if (c % k == 0) {
                pre.next = null;
                nodes.add(singleHead);
                singleHead = current;
            } else if (current == null) {
                nodes.add(singleHead);
                skipTail = true;
                break;
            }
        }
        if (skipTail &&  nodes.size() == 1) {
            return head;
        }
        ListNode resultHead = null;
        ListNode resultTail = null;
        for (int i = 0; i < nodes.size(); i ++) {
            ListNode n = nodes.get(i);
            if (skipTail && i == nodes.size() - 1) {
                resultTail.next = n;
            } else {
                ListNode[] startAndEnd = revertNode(n);
                if (resultHead == null) {
                    resultHead = startAndEnd[0];
                } else {
                    resultTail.next = startAndEnd[0];
                }
                resultTail = startAndEnd[1];
            }
        }
        return resultHead;
    }

    public ListNode[] revertNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            current.next = pre;
            pre = current;
            current = next;
            if (current != null) {
                next = current.next;
            } else {
                next = null;
            }
        }
        return new ListNode[] {pre, head};
    }

}

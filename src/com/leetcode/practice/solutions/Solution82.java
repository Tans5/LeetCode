package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode resultHead = null;
        ListNode resultTail = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            if (pre == null && next == null) {
                resultHead = current;
                resultTail = current;
            }
            if (pre == null && next != null) {
                if (current.val != next.val) {
                    resultHead = current;
                    resultTail = current;
                    current.next = null;
                }
            }
            if (pre != null && next == null) {
                if (pre.val != current.val) {
                    pre.next = null;

                    if (resultHead == null) {
                        resultHead = current;
                    } else {
                        resultTail.next = current;
                    }
                    resultTail = current;
                }
            }
            if (pre != null && next != null) {
                if (pre.val != current.val && current.val != next.val) {
                    pre.next = null;
                    current.next = null;
                    if (resultHead == null) {
                        resultHead = current;
                    } else {
                        resultTail.next = current;
                    }
                    resultTail = current;
                }
            }
            pre = current;
            current = next;
            if (current != null) {
                next = current.next;
            } else {
                next = null;
            }
        }
        return resultHead;
    }
}

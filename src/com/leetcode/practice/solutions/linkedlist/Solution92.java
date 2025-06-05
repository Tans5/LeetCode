package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode startNode = head;
        ListNode previous = null;
        for (int i = 0; i < left - 1; i ++) {
            previous = startNode;
            startNode = startNode.next;
        }
        ListNode reverseRoot = reverse(startNode, right - left + 1);
        if (left <= 1) {
            return reverseRoot;
        } else {
            previous.next = reverseRoot;
            return head;
        }
    }


    private ListNode reverse(ListNode start, int count) {
        if (start == null) {
            return null;
        }
        ListNode previous = null;
        ListNode cursor = start;
        ListNode temp;
        for (int i = 0; i < count; i ++) {
            temp = cursor;
            if (temp == null) {
                break;
            }
            cursor = cursor.next;
            temp.next = previous;
            previous = temp;
        }
        start.next = cursor;
        return previous;
    }
}

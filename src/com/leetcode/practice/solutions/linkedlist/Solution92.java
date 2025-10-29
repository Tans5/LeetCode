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
        ListNode result = new ListNode();
        ListNode resultCursor = result;
        ListNode cursor = head;
        for (int i = 1; i < left; i ++) {
            ListNode temp = cursor;
            cursor = cursor.next;
            temp.next = null;
            resultCursor.next = temp;
            resultCursor = temp;
        }
        ListNode pre = null;
        ListNode revertLast = cursor;
        for (int i = 0; i < right - left + 1; i ++) {
            ListNode temp = cursor;
            cursor = cursor.next;
            temp.next = pre;
            pre = temp;
        }
        resultCursor.next = pre;
        if (revertLast != null) {
            revertLast.next = cursor;
        }
        return result.next;
    }
}

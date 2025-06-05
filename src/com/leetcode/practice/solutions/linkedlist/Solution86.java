package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = null;
        ListNode leftCursor = null;
        ListNode right = null;
        ListNode rightCursor = null;
        ListNode temp;
        ListNode cursor = head;
        while (cursor != null) {
            temp = cursor;
            cursor = cursor.next;
            temp.next = null;
            if (temp.val < x) {
                // left
                if (left == null) {
                    left = temp;
                    leftCursor = left;
                } else {
                    leftCursor.next = temp;
                    leftCursor = temp;
                }
            } else {
                // right
                if (right == null) {
                    right = temp;
                    rightCursor = right;
                } else {
                    rightCursor.next = temp;
                    rightCursor = temp;
                }
            }
        }
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            leftCursor.next = right;
            return left;
        }
    }
}

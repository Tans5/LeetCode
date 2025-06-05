package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowCursor = head;
        ListNode fastCursor = head.next;
        ListNode meetNode = null;
        while (fastCursor != null && fastCursor.next != null) {
            if (slowCursor == fastCursor) {
                meetNode = slowCursor;
                break;
            }
            slowCursor = slowCursor.next;
            fastCursor = fastCursor.next.next;
        }
        if (meetNode == null) {
            // 没有环
            return null;
        } else {
            // 有环
            // 计算环的大小
            int cycleLen = 1;
            slowCursor = slowCursor.next;
            while (slowCursor != meetNode) {
                slowCursor = slowCursor.next;
                cycleLen ++;
            }

            // 重置快慢指针
            slowCursor = head;
            fastCursor = head;
            // 让快指针先走 cycleLen
            for (int i = 0; i < cycleLen; i ++) {
                fastCursor = fastCursor.next;
            }

            // 再让慢指针和快指针一起走，他们相遇的节点就是首次出现环的地方。
            while (true) {
                if (slowCursor == fastCursor) {
                    return slowCursor;
                } else {
                    slowCursor = slowCursor.next;
                    fastCursor = fastCursor.next;
                }
            }
        }
    }

}

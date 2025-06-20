package com.leetcode.practice.solutions.linkedlist;

import com.leetcode.practice.solutions.others.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class Solution142 {


    /**
     * 设 head 到环的距离为 D; 环的长度为 C; 如环第一个节点到第一次相交点的距离为 P; 假如第一次相遇时快指针已经绕环 k 圈；
     * 相遇时慢指针走的距离是：D + P
     * 快指针走的距离是：D + P + k * C
     * 快指针走的距离是慢指针的二倍: 2 * (D + P) = D + P + k * C  => D = (k - 1) * C + C - P
     * 通过上面的推断可以可以得出，在快慢指针相遇后，将快指针移动到 head ，然后在将快指针的速度设置为和慢指针一样，然后再移动，他们再次相遇的点就是进入环的点。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowCursor = head;
        ListNode fastCursor = head.next;
        while (true) {
            if (fastCursor == null || fastCursor.next == null) {
                return null;
            }
            if (slowCursor == fastCursor) {
                slowCursor = slowCursor.next;
                break;
            }
            slowCursor = slowCursor.next;
            fastCursor = fastCursor.next.next;
        }
        fastCursor = head;
        while (true) {
            if (fastCursor == slowCursor) {
                return fastCursor;
            }
            fastCursor = fastCursor.next;
            slowCursor = slowCursor.next;
        }
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> route = new HashSet<>();
        ListNode cursor = head;
        while (cursor != null) {
            if (route.contains(cursor)) {
                return cursor;
            } else {
                route.add(cursor);
                cursor = cursor.next;
            }
        }
        return null;
    }
}

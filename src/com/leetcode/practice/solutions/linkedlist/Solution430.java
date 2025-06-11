package com.leetcode.practice.solutions.linkedlist;

/**
 * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
 *
 * 给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。
 *
 * 返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null 。
 */
public class Solution430 {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        flattenLast(head);
        return head;
    }

    // return last node.
    private Node flattenLast(Node head) {
        Node previous = head;
        Node cursor = head;
        while (cursor != null) {
            Node child = cursor.child;
            if (child != null) {
                cursor.child = null;
                Node next = breakLink(cursor);
                Node flattenLast = flattenLast(child);
                cursor.next = child;
                child.prev = cursor;
                if (next != null) {
                    flattenLast.next = next;
                    next.prev = flattenLast;
                }
                previous = flattenLast;
                cursor = previous.next;
            } else {
                previous = cursor;
                cursor = cursor.next;
            }
        }
        return previous;
    }

    // return next node.
    private Node breakLink(Node n) {
        Node next = n.next;
        n.next = null;
        if (next != null) {
            next.prev = null;
        }
        return next;
    }


    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}

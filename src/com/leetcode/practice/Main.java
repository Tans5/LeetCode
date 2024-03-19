package com.leetcode.practice;


import com.leetcode.practice.solutions.*;
import com.leetcode.practice.solutions.others.ListNode;


public class Main {
    public static void main(String[] args) {

        Solution146_2 s = new Solution146_2(2);
        s.put(1, 1);
        s.put(2, 2);
        s.get(1);
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4, 4);
        int a = s.get(1);
        int b = s.get(3);
        int c = s.get(4);
        System.out.println(a);
    }
}

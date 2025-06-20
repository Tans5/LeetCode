package com.leetcode.practice;

import com.leetcode.practice.solutions.greedy.Solution134;


public class Main {
    public static void main(String[] args) {
        Solution134 s = new Solution134();
        int count = s.canCompleteCircuit(new int[] {2, 3, 4}, new int[] { 3, 4, 3});
        System.out.println(count);
    }
}

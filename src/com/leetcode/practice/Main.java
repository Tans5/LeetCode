package com.leetcode.practice;

import com.leetcode.practice.solutions.graph.Solution787;


public class Main {
    public static void main(String[] args) {
        Solution787 s = new Solution787();
        int ret = s.findCheapestPrice(
                4,
                new int[][]{
                        new int[] {0, 1, 100},
                        new int[] {1, 2, 100},
                        new int[] {2, 0, 100},
                        new int[] {2, 3, 200},
                        new int[] {1, 3, 600}
                },
                0,
                3,
                1
        );
        System.out.println(ret);
    }
}

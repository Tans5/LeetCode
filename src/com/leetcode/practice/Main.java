package com.leetcode.practice;


import com.leetcode.practice.solutions.*;


public class Main {
    public static void main(String[] args) {
        Solution207 s = new Solution207();
        boolean result = s.canFinish(5, new int[][]{
                new int[] {1,0},
                new int[] {1,2},
                new int[] {0,1},
                new int[] {3,2},
        });
        System.out.println(result);
    }
}

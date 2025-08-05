package com.leetcode.practice;

import com.leetcode.practice.solutions.array.Solution992;


public class Main {
    public static void main(String[] args) {
        Solution992 s = new Solution992();
        int ret = s.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2);
        System.out.println(ret);
    }
}

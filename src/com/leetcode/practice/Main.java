package com.leetcode.practice;


import com.leetcode.practice.solutions.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Solution40_2 s = new Solution40_2();
        int[] input = new int[] { 10,1,2,7,6,1,5 };
        List<List<Integer>> result = s.combinationSum2(input, 8);
        System.out.println(result);
    }
}

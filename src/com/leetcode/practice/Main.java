package com.leetcode.practice;

import com.leetcode.practice.solutions.backtracking.Solution216;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution216 s = new Solution216();
        List<List<Integer>> ret = s.combinationSum3(3, 9);
        System.out.println(ret);
    }
}

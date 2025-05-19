package com.leetcode.practice;

import com.leetcode.practice.solutions.backtracking.Solution22;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        List<String> result = s.generateParenthesis(3);
        System.out.println(result);
    }
}

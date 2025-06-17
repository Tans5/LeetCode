package com.leetcode.practice;

import com.leetcode.practice.solutions.array.Solution438;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Solution438 s = new Solution438();
        List<Integer> result = s.findAnagrams("baa", "aa");
        System.out.println(result);
    }
}

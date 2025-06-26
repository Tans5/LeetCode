package com.leetcode.practice;

import com.leetcode.practice.solutions.array.Solution127;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Solution127 s = new Solution127();
        String[] words = new String[] {"hot","dog","dot"};
        System.out.println(s.ladderLength("hot", "dog",  new ArrayList<>(Arrays.asList(words))));
    }
}

package com.leetcode.practice;


import com.leetcode.practice.solutions.*;


public class Main {
    public static void main(String[] args) {
        Solution290 s = new Solution290();
        boolean result = s.wordPattern("abba", "dog cat cat dog");
        System.out.println(result);
    }
}

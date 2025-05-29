package com.leetcode.practice;

import com.leetcode.practice.solutions.dynamicprograming.Solution221;

public class Main {
    public static void main(String[] args) {
        Solution221 s = new Solution221();
       int r = s.maximalSquare(new char[][] {
               new char[] {'1','0','1','0','0'},
               new char[] {'1','0','1','1','1'},
               new char[] {'1','1','1','1','1'},
               new char[] {'1','0','0','1','0'},
       });
       System.out.println(r);
    }
}
